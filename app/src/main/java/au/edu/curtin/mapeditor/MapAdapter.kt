package au.edu.curtin.mapeditor

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MapAdapter(private val mapData:MapData,
                 private val handler : (Structure) -> Unit) : RecyclerView.Adapter<MapViewHolder>() {
    private var communication = Communication()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.grid_cell,parent,false)

        return MapViewHolder(view, parent)
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        val row = position % MapData.HEIGHT
        val col = position / MapData.HEIGHT

        val mapElement = mapData.get(row, col)
        if (mapElement != null) {
            holder.northWestBlock.setImageResource(mapElement.northWest)
            holder.northEastBlock.setImageResource(mapElement.northEast)
            holder.southWestBlock.setImageResource(mapElement.southWest)
            holder.southEastBlock.setImageResource(mapElement.southEast)
        }
        holder.itemView.setOnClickListener {
            val selected = communication.getSelected()
            Log.v("MESSAGE", "NULL")
            if (selected != null) {
                Log.v("MESSAGE", "NOT NULL")
                handler(selected)
            }
        }

    }

    override fun getItemCount(): Int {
        return (MapData.HEIGHT * MapData.WIDTH)
    }
}
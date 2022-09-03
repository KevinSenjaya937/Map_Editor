package au.edu.curtin.mapeditor

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MapAdapter(private val mapData:MapData,
                 private val handler : (postitionData) -> Unit) : RecyclerView.Adapter<MapViewHolder>() {

    class postitionData(val pos: Int, val row: Int, val col: Int) {
    }

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
            if (mapElement.structure != null) {
                holder.overlay.setImageResource(mapElement.structure.drawableId)
            }

        }
        holder.itemView.setOnClickListener {
            handler(packageData(position, row, col))
        }
    }

    override fun getItemCount(): Int {
        return (MapData.HEIGHT * MapData.WIDTH)
    }

    fun packageData(position: Int, row: Int, col: Int): postitionData {
        return postitionData(position,row,col)
    }



}
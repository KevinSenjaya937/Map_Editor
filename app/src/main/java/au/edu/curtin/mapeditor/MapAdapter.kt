package au.edu.curtin.mapeditor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MapAdapter(private val mapData:MapData) : RecyclerView.Adapter<MapAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val northWestBlock : ImageView
        val northEastBlock : ImageView
        val southWestBlock : ImageView
        val southEastBlock : ImageView

        init {
            northWestBlock = view.findViewById(R.id.northwest)
            northEastBlock = view.findViewById(R.id.northeast)
            southWestBlock = view.findViewById(R.id.southwest)
            southEastBlock = view.findViewById(R.id.southeast)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_selection,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = position % mapData.HEIGHT
        val col = position / mapData.HEIGHT

        val mapElement = mapData[row, col]
        if (mapElement != null) {
            holder.northWestBlock.setImageResource(mapElement.northWest)
            holder.northEastBlock.setImageResource(mapElement.northEast)
            holder.southWestBlock.setImageResource(mapElement.southWest)
            holder.southEastBlock.setImageResource(mapElement.southEast)
        }
    }

    override fun getItemCount(): Int {
        return mapData.WIDTH * mapData.HEIGHT
    }
}
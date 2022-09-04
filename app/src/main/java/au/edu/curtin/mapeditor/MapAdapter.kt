package au.edu.curtin.mapeditor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MapAdapter(private val mapData:MapData,
                 private val selectorFragment: SelectorFragment,
                 private val context: Context) : RecyclerView.Adapter<MapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.grid_cell,parent,false)

        return MapViewHolder(view, parent)
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        val row = position % MapData.HEIGHT
        val col = position / MapData.HEIGHT

        val mapElement = mapData.get(row, col)
        holder.bind(mapElement)
        holder.itemView.setOnClickListener {
            if (mapElement.isBuildable){
                holder.update(selectorFragment.getSelectedStructure())
            }
            else {
                Toast.makeText(context, "Location is not buildable", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return (MapData.HEIGHT * MapData.WIDTH)
    }
}
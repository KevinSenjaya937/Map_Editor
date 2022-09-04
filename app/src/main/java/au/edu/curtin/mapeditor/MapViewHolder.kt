package au.edu.curtin.mapeditor

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MapViewHolder(view: View, parent: ViewGroup) : RecyclerView.ViewHolder(view) {

    private var mapElement: MapElement? = null
    private val northWestBlock : ImageView
    private val northEastBlock : ImageView
    private val southWestBlock : ImageView
    private val southEastBlock : ImageView
    private val overlay : ImageView
    private val size = parent.measuredHeight / MapData.HEIGHT + 1
    private val lp: ViewGroup.LayoutParams = itemView.layoutParams

    init {
        lp.width = size
        lp.height = size
        northWestBlock = view.findViewById(R.id.northwest)
        northEastBlock = view.findViewById(R.id.northeast)
        southWestBlock = view.findViewById(R.id.southwest)
        southEastBlock = view.findViewById(R.id.southeast)
        overlay = view.findViewById(R.id.overlay)
    }

    fun bind(mapElement: MapElement) {
        this.mapElement = mapElement
        northWestBlock.setImageResource(mapElement.northWest)
        northEastBlock.setImageResource(mapElement.northEast)
        southWestBlock.setImageResource(mapElement.southWest)
        southEastBlock.setImageResource(mapElement.southEast)
        if (mapElement.structure != null) {
            overlay.setImageResource(mapElement.structure.drawableId)
        }
    }

    fun update(structure: Structure) {
        overlay.setImageResource(structure.drawableId)

    }

}
package au.edu.curtin.mapeditor

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MapViewHolder(view: View, parent: ViewGroup) : RecyclerView.ViewHolder(view) {

    val northWestBlock : ImageView
    val northEastBlock : ImageView
    val southWestBlock : ImageView
    val southEastBlock : ImageView
    val size = parent.measuredHeight / MapData.HEIGHT + 1
    val lp: ViewGroup.LayoutParams = itemView.layoutParams


    init {
        lp.width = size
        lp.height = size
        northWestBlock = view.findViewById(R.id.northwest)
        northEastBlock = view.findViewById(R.id.northeast)
        southWestBlock = view.findViewById(R.id.southwest)
        southEastBlock = view.findViewById(R.id.southeast)
    }
}
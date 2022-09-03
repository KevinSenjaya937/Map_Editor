package au.edu.curtin.mapeditor

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val icon : ImageView
    val descriptionText : TextView

    init {
        icon = view.findViewById(R.id.selectionImage)
        descriptionText = view.findViewById(R.id.selectionDescription)
        itemView.setOnClickListener {

        }
    }
}
package au.edu.curtin.mapeditor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectorAdapter(private val dataSet: StructureData,
                      private val handler : (Structure) -> Unit) : RecyclerView.Adapter<SelectorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_selection,parent,false)
        val viewHolder = SelectorViewHolder(view)

        viewHolder.itemView.setOnClickListener {

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        val data = dataSet[position]
        holder.icon.setImageResource(data.drawableId)
        holder.descriptionText.text = data.label

        holder.itemView.setOnClickListener {
            handler(data)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size()
    }
}

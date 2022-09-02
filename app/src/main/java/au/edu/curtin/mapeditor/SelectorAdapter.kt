package au.edu.curtin.mapeditor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectorAdapter(private val dataSet: StructureData) : RecyclerView.Adapter<SelectorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon : ImageView
        val descriptionText : TextView

        init {
            icon = view.findViewById(R.id.selectionImage)
            descriptionText = view.findViewById(R.id.selectionDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_selection,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataSet[position]
        holder.icon.setImageResource(data.drawableId)
        holder.descriptionText.text = data.label
    }

    override fun getItemCount(): Int {
        return dataSet.size()
    }
}

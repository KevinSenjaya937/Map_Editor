package au.edu.curtin.mapeditor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectorAdapter(private val dataSet: StructureData) : RecyclerView.Adapter<SelectorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_selection,parent,false)
        return SelectorViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectorViewHolder, position: Int) {
        var data = dataSet[position]
        holder.icon.setImageResource(data.drawableId)
        holder.descriptionText.text = data.label
    }

    override fun getItemCount(): Int {
        return dataSet.size()
    }
}

package au.edu.curtin.mapeditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectorFragment(private val structureData: StructureData) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var selectedStructure : Structure

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.selectorRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SelectorAdapter(structureData) {
                selected -> selectedStructure = selected
                showToast(selectedStructure)
        }
    }

    fun getSelectedStructure() : Structure {
        return selectedStructure
    }

    private fun showToast(selected : Structure) {
        Toast.makeText(context, selected.label + " selected", Toast.LENGTH_SHORT).show()
    }



}
package au.edu.curtin.mapeditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MapFragment(private val mapData: MapData,
                  private val selectorFragment: SelectorFragment) : Fragment() {
    private lateinit var adapter: MapAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager =
            GridLayoutManager(
                activity,
                MapData.HEIGHT,
                RecyclerView.HORIZONTAL,
                false
            )
        recyclerView = view.findViewById(R.id.mapRecyclerView)
        recyclerView.layoutManager = layoutManager
        adapter = MapAdapter(mapData) {
            selected -> mapData.get(selected.row, selected.col).structure = selectorFragment.getSelectedStructure()
            adapter.notifyItemChanged(selected.pos)
            showToast(selected.row, selected.col)
        }

        recyclerView.adapter = adapter
    }

    fun showToast(row: Int, col:Int) {
        Toast.makeText(context, mapData.get(row,col).structure.drawableId.toString(), Toast.LENGTH_SHORT).show()
    }

    fun update() {

    }

}
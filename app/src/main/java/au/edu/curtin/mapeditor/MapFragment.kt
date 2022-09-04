package au.edu.curtin.mapeditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(R.layout.fragment_map, container, false)
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
        adapter = context?.let { MapAdapter(mapData, selectorFragment, it) }!!
        recyclerView.adapter = adapter
    }
}
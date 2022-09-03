package au.edu.curtin.mapeditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MapFragment(private val mapData: MapData) : Fragment() {
    private lateinit var adapter: MapAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.mapRecyclerView)
        val layoutManager =
            GridLayoutManager(
                activity,
                MapData.WIDTH,
                RecyclerView.HORIZONTAL,
                false
            )
        adapter = MapAdapter(mapData)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
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
        adapter = MapAdapter(mapData)
        recyclerView.adapter = adapter
    }


}
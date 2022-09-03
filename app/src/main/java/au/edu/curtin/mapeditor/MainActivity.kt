package au.edu.curtin.mapeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapData = MapData.get()

        val selectorData = StructureData.get()

        replaceMapFragment(MapFragment(mapData))
        replaceSelectorFragment(SelectorFragment(selectorData))
    }

    private fun replaceMapFragment(mapFragment: MapFragment) {
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.map, mapFragment)
        fragmentTransaction.commit()
    }

    private fun replaceSelectorFragment(selectorFragment: SelectorFragment) {
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.selector, selectorFragment)
        fragmentTransaction.commit()
    }

}
package au.edu.curtin.mapeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapData = MapData.get()
        val selectorData = StructureData.get()

        val fm = supportFragmentManager



        val selectorFragment = fm.findFragmentById(R.id.selector)
        if (selectorFragment == null) {
            fm.beginTransaction().add(R.id.selector, SelectorFragment()).commit()
        }
    }
}
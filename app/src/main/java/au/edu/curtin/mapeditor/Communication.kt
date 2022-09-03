package au.edu.curtin.mapeditor

import androidx.lifecycle.ViewModel

class Communication : ViewModel() {
    private var selectedStructure : Structure? = null

    fun setSelected(selected : Structure) {
        this.selectedStructure = selected
    }

    fun getSelected() : Structure? {
        return selectedStructure
    }

}
package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TabViewModel: ViewModel() {
    private val _index = MutableLiveData(0)
    val index get() = _index.value

    fun updateIndex(it: Int) {
        _index.postValue(it)
    }

}

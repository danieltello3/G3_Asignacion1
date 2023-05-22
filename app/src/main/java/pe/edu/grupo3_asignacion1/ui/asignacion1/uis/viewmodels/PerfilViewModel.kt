package pe.edu.grupo3_asignacion1.ui.asignacion1.uis.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.services.ImageService

class PerfilViewModel: ViewModel() {
    private val _id = MutableLiveData(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _photoList = mutableStateOf<List<Photo>?>(
        listOf()
    )

    val photos get() = _photoList.value
    fun setPhotos(userId: Int){
        _photoList.value = ImageService.fetchByUserId(userId)
    }


}
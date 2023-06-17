package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.services.ImageService
import kotlin.concurrent.thread

class ImagesViewModel: ViewModel() {
    private val _images = mutableStateOf<List<Photo>?>(listOf())
    val images get() = _images.value
    fun setImages(id: Int) {
        val apiService = BackendClient.buildService(ImageService::class.java)
        thread {
            try {
                val response = apiService.fetchImageByUserId(id).execute()
                if (response.isSuccessful) {
                    _images.value = response.body()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
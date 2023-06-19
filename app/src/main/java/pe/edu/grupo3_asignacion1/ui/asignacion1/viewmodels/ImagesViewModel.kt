package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.configs.LocalDB
import pe.edu.grupo3_asignacion1.daos.ProfileKeyDao
import pe.edu.grupo3_asignacion1.daos.UserDao
import pe.edu.grupo3_asignacion1.models.Photo
import pe.edu.grupo3_asignacion1.models.ProfileKey
import pe.edu.grupo3_asignacion1.models.User
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

    fun uploadImages(activity: Activity) {
        val apiService = BackendClient.buildService(ImageService::class.java)
        viewModelScope.launch{
            try {
                withContext(Dispatchers.IO) {
                    val database = LocalDB.getDatabase(activity as Context)
                    val photoDao = database.photoDao()
                    val profileKeyDao: ProfileKeyDao = database.profileKeyDao()
                    val profileKey: ProfileKey? = profileKeyDao.getProfileUserById(1)
                    if (profileKey == null){
                        // val response = apiService.fetchAll("", "")
                        // acceder a db y traer el usuario logueado
                        val userDao = database.userDao()
                        val user: User = userDao.getUser()!!
                        // traer los pokemons del servidor de ese usuario
                        thread {
                            val response = apiService.fetchImageByUserId(user.id).execute()
                            if(response.isSuccessful){
                                val photos: List<Photo> = response.body()!!
                                _images.value = photos
                                photoDao.insertMany(photos)
                                profileKeyDao.setFirstLoad(ProfileKey(userId = 1, firstLoad = true))
                            }
                        }
                    }else{
                        _images.value = photoDao.getPhotos()
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
                activity.runOnUiThread{
                    Toast.makeText(
                        activity,
                        "Error HTTP: No se pudo traer el pokemon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}
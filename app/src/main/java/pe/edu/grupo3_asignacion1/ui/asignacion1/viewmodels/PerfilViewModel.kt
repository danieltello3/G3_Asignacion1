package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.services.UserService
import kotlin.concurrent.thread

class PerfilViewModel: ViewModel() {
    private val _id = MutableLiveData<Int>(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String){
        _contrasenia.postValue(it)
    }

    private val _nombre = MutableLiveData<String>("")
    var nombre: LiveData<String> = _nombre
    fun updateNombre(it: String){
        _nombre.postValue(it)
    }

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String){
        _correo.postValue(it)
    }

    private val _imagen = MutableLiveData<String>("")
    var imagen: LiveData<String> = _imagen
    fun updateImagen(it: String){
        _imagen.postValue(it)
    }

    fun setUsuario(id: Int){
        val apiService = BackendClient.buildService(UserService::class.java)

        thread {
            try {
                val response = apiService.fetchOne(id).execute()
                if (response.isSuccessful) {
                    val usuario = response.body()!!
                    this.updateId(usuario.id)
                    this.updateUsuario(usuario.usuario)
                    this.updateCorreo(usuario.correo)
                    this.updateNombre(usuario.nombre)
                    this.updateImagen(usuario.imagen)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
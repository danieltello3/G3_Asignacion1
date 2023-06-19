package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.configs.LocalDB
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

    fun setUsuarioLocal(context: Context){
        val _this = this
        viewModelScope.launch{
            try {
                withContext(Dispatchers.IO) {
                    val database = LocalDB.getDatabase(context)
                    val userDao = database.userDao()
                    val usuario: User = userDao.getUser()!!
                    _this.updateId(usuario!!.id)
                    _this.updateUsuario(usuario!!.usuario)
                    _this.updateCorreo(usuario!!.correo)
                    _this.updateNombre(usuario!!.nombre)
                    _this.updateImagen(usuario!!.imagen)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                val activity = context as Activity
                activity.runOnUiThread{
                    Toast.makeText(
                        activity,
                        "Error: No se pudo mostrar el usuario",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
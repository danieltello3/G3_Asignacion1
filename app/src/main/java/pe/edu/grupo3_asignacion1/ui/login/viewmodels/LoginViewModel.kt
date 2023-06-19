package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.activities.AppActivity
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.configs.LocalDB
import pe.edu.grupo3_asignacion1.models.beans.User
import pe.edu.grupo3_asignacion1.models.requests.UserValidate
import pe.edu.grupo3_asignacion1.services.UserService

class LoginViewModel(): ViewModel() {

    //USUARIO
    private val _usuario = MutableLiveData("")
    var usuario: LiveData<String> = _usuario
    lateinit var isLoggedIn: LiveData<Boolean>
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    //CONTRASEÑA
    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String){
        _contrasenia.postValue(it)
    }

    //MENSAJE DE ERROR
    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun validar(context: Context, navController: NavHostController){
        Log.d("Entra a la funcion validar.","Entra a la funcion validar")
        //para hacer cambios en la bd local es de esta manera:
        viewModelScope.launch{
            //Esto es para hacer llamadas remotas
            val apiService = BackendClient.buildService(UserService::class.java)
            Log.d("TAG.","Entra al TRY")
            try{
                withContext(Dispatchers.IO){
                    Log.d("TAG.",usuario.value!!+" "+contrasenia.value!!)
                    //llamar a dataclass UserValidate. response = llama a la funcion validate de UserService
                    val response = apiService.validate(UserValidate(usuario.value!!, contrasenia.value!!))
                    //Log.d("TAG.",response.toString())
                    if (response.code() == 200){
                        //Log.d("TAG.",response.body().toString())
                        val user: User = response.body()!!
                        val database = LocalDB.getDatabase(context)
                        val userDao = database.userDao()
                        userDao.deleteAll()
                        userDao.insert(user)
                        updateMensaje("Usuario OK")

                        withContext(Dispatchers.Main) {
                            updateMensaje("")
                            navController.navigate("/profile/")
                        }

                    }else if(response.code() == 500){
                        updateMensaje("Error: Usuario y contraseña no válidos")
                    }else{
                        updateMensaje("Error: Ocurrió un error no esperado")
                    }
                }


            }catch(e: Exception){
                Log.d("ERROR",e.toString())
                val activity = context as Activity

                activity.runOnUiThread (Runnable(){
                    Toast.makeText(activity,"Error, no se pudo validar el usuario",Toast.LENGTH_SHORT
                    ).show()
                })

            }
        }

    }

}
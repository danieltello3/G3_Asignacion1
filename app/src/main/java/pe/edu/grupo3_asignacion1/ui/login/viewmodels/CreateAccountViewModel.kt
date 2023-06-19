/*
package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.activities.AppActivity
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.models.beans.User
import pe.edu.grupo3_asignacion1.models.requests.UserCreate
import pe.edu.grupo3_asignacion1.services.UserService
import java.util.regex.Matcher
import java.util.regex.Pattern

class CreateAccountViewModel : ViewModel(){
    private val _usuario = MutableLiveData("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String){
        _correo.postValue(it)
    }

    private val _contrasenia = MutableLiveData<String>("")
    var contrasenia: LiveData<String> = _contrasenia
    fun updateContrasenia(it: String){
        _contrasenia.postValue(it)
    }

    private val _repeatcontrasenia = MutableLiveData<String>("")
    var repeatcontrasenia: LiveData<String> = _repeatcontrasenia
    fun updateRepeatContrasenia(it: String){
        _repeatcontrasenia.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun createNewAccount(context: Context){
        //para llamar a backend (bd remota)
        val apiService = BackendClient.buildService(UserService::class.java)
        //Para validacion del correo
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val email = correo.value
        val matcher: Matcher = pattern.matcher(email)
        val matchFound: Boolean = matcher.matches()
        viewModelScope.launch {
            try{
                withContext(Dispatchers.IO){
                    //Para validacion de usuario
                    if(usuario.value!! != "" && contrasenia.value!! != "" && correo.value!! != "" && repeatcontrasenia.value!! != ""){
                        //Si es que no son nulas las casillas
                        val response = apiService.getUserName(usuario.value!!)
                        //val bool = UserService.verifyIfUserAlreadyExists(usuario.value!!)
                        if(response.code()==200){
                            updateMensaje("El usuario ingresado ya existe.")
                        }else{
                            if(matchFound){
                                //Validar si el correo ya existe
                                val response2 = apiService.getEmail(correo.value!!)
                                if(response2.code()==200){
                                    updateMensaje("El correo ingresado ya se encuentra registrado.")
                                }else{
                                    //Para coincidencia de contraseñas
                                    if(contrasenia.value!! != repeatcontrasenia.value!!){
                                        updateMensaje("Las contraseñas deben ser iguales")
                                    }else{
                                        //Todo bien, todo correcto
                                        updateMensaje("Todo OK")
                                        val userCreate : UserCreate = UserCreate(usuario.value!!,contrasenia.value!!,correo.value!!)
                                        val response3 =  apiService.createAccount(userCreate)
                                        val user: User = response3.body()!!
                                        //Ingresar lógica de ir a la página de Home
                                        Handler().postDelayed({
                                            updateMensaje("")
                                            val appActivity =  Intent(context, AppActivity::class.java)
                                            appActivity.putExtra("user_id",user.id)
                                            context.startActivity(
                                                appActivity
                                            )
                                        }, 1000)
                                    }
                                }
                            }else{
                                updateMensaje("Error: Ingrese un correo válido")
                            }
                        }
                    }else{
                        updateMensaje("Complete todas las casillas")
                    }

                }
            }
            catch(e: Exception){
                val activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, no se pudo crear el usuario",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }



    }
}*/

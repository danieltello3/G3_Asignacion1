package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.activities.AppActivity
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
        //Para validacion del correo
        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
        val email = correo.value
        val matcher: Matcher = pattern.matcher(email)
        val matchFound: Boolean = matcher.matches()

        //Para validacion de usuario
        if(usuario.value!! != "" && contrasenia.value!! != "" && correo.value!! != "" && repeatcontrasenia.value!! != ""){
            //Si es que no son nulas las casillas
            val bool = UserService.verifyIfUserAlreadyExists(usuario.value!!)
            if(bool){
                updateMensaje("El usuario ingresado ya existe.")
            }else{
                if(matchFound){
                    //Validar si el correo ya existe
                    val bool2 =UserService.verifyIfEmailAlreadyExists(correo.value!!)
                    if(bool2){
                        updateMensaje("El correo ingresado ya se encuentra registrado.")
                    }else{
                        //Para coincidencia de contraseñas
                        if(contrasenia.value!! != repeatcontrasenia.value!!){
                            updateMensaje("Las contraseñas deben ser iguales")
                        }else{
                            //Todo bien, todo correcto
                            updateMensaje("Todo OK")
                            val id = UserService.create(usuario.value!!,contrasenia.value!!,correo.value!!)
                            //Ingresar lógica de ir a la página de Home
                            Handler().postDelayed({
                                updateMensaje("")
                                val appActivity =  Intent(context, AppActivity::class.java)
                                appActivity.putExtra("user_id", id)
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
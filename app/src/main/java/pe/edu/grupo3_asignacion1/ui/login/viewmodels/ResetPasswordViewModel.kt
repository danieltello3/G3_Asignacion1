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

class ResetPasswordViewModel:ViewModel(){
    private val _correo = MutableLiveData<String>("")
    var correo: LiveData<String> = _correo
    fun updateCorreo(it: String){
        _correo.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    fun reset(context: Context){
        //Validar si el campo está lleno o vacío
        if(correo.value!! != ""){
            val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
            val email = correo.value
            val matcher: Matcher = pattern.matcher(email)
            val matchFound: Boolean = matcher.matches()
            //Validar si tiene formato de correo
            if(matchFound){
                //Validar si existe en la fuente de datos
                val bool = UserService.verifyIfEmailAlreadyExists(correo.value!!)
                if(bool){
                    updateMensaje("Todo OK.")
                    //Aquí regresa a la Activity de Login

                }
            }else{
                updateMensaje("Error: Ingrese un correo válido")
            }
        }else{
            updateMensaje("Complete el campo de Correo.")
        }

    }
}
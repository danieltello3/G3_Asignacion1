package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.activities.AppActivity
import pe.edu.grupo3_asignacion1.configs.BackendClient
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

        val apiService = BackendClient.buildService(UserService::class.java)
        //Validar si el campo está lleno o vacío
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    if(correo.value!! != ""){
                        val pattern: Pattern = Pattern.compile(".+@.+\\.[a-z]+")
                        val email = correo.value
                        val matcher: Matcher = pattern.matcher(email)
                        val matchFound: Boolean = matcher.matches()
                        //Validar si tiene formato de correo
                        if (matchFound){
                            val response = apiService.getUserName(correo.value!!)
                            //val bool = UserService.verifyIfUserAlreadyExists(usuario.value!!)
                            if(response.code()==200){
                                updateMensaje("Se envió correo para recuperar contrasenia.")
                            }
                        }else{
                            updateMensaje("Error: Ingrese un correo válido")
                        }
                    }else{
                        updateMensaje("Error: Complete el campo de Correo.")
                    }
                }
            }catch (e:Exception){
                val activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, no se pudo enviar el correo.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}
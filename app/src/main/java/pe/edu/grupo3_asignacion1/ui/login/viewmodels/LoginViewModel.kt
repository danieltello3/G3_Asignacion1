/*
package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.activities.AppActivity
import pe.edu.grupo3_asignacion1.services.UserService

class LoginViewModel: ViewModel() {

    //USUARIO
    private val _usuario = MutableLiveData("")
    var usuario: LiveData<String> = _usuario
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

    fun validar(context: Context){
        val id: Int = UserService.validate(usuario.value!!, contrasenia.value!!)
        if(id == 0){
            updateMensaje("Error: Usuario y contraseña no válidos")
        }else{
            updateMensaje("Todo OK")
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
}*/

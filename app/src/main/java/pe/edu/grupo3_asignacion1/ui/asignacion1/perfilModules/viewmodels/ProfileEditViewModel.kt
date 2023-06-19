package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels

import android.content.Context
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.services.UserService2

class ProfileEditViewModel: ViewModel() {
    private val _id = MutableLiveData(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _url = MutableLiveData("")
    var url: LiveData<String> = _url
    fun updateUrl(it: String){
        _url.postValue(it)
    }

    private val _name = MutableLiveData("")
    var name: LiveData<String> = _name
    fun updateName(it: String){
        _name.postValue(it)
    }

    private val _user = MutableLiveData("")
    var user: LiveData<String> = _user
    fun updateUser(it: String){
        _user.postValue(it)
    }

    private val _mail = MutableLiveData("")
    var mail: LiveData<String> = _mail
    fun updateMail(it: String){
        _mail.postValue(it)
    }

    private val _mensaje = MutableLiveData<String>("")
    var mensaje: LiveData<String> = _mensaje
    fun updateMensaje(it: String){
        _mensaje.postValue(it)
    }

    private val _mensajePassword = MutableLiveData<String>("")
    var mensajePassword: LiveData<String> = _mensajePassword
    fun updateMensajePassword(it: String){
        _mensajePassword.postValue(it)
    }

    private val _password = MutableLiveData<String>("")
    var password: LiveData<String> = _password
    fun updatePassword(it: String){
        _password.postValue(it)
    }

    private val _newPassword = MutableLiveData<String>("")
    var newPassword: LiveData<String> = _newPassword
    fun updateNewPassword(it: String){
        _newPassword .postValue(it)
    }

    private val _newPasswordConfirm = MutableLiveData<String>("")
    var newPasswordConfirm: LiveData<String> = _newPasswordConfirm
    fun updateNewPasswordConfirm(it: String){
        _newPasswordConfirm.postValue(it)
    }

    fun getUser(id: Int){
        val user: User = UserService2.fetchOne(id)
        if(user != null){
            this.updateUser(user.usuario)
            this.updateName(user.nombre)
            this.updateMail(user.correo)
            this.updateUrl(user.imagen)
            this.updateId(user.id)
        }
    }

    fun validar(context: Context){
        val message: String = UserService2.existData(mail.value!!,user.value!!,id.value!!)
        if(message != "OK"){
            updateMensaje("Error: $message")
        }else{
            UserService2.updateUser(id.value!!,name.value!!,user.value!!,mail.value!!)
            updateMensaje("Perfil Editado")
        }
        Handler().postDelayed({
            updateMensaje("")
        }, 1000)
    }

    fun validarChangePassword(context: Context) {
        var message: String = "Contraseña Cambiada"
        val res: Boolean = UserService2.validatePassword(id.value!!, password.value!!)
        if(!res){
            message = "Error: Contraseña antigua no coincide"
        }
        if(newPassword.value != newPasswordConfirm.value){
            message = "Error: La nueva contraseña no coincide con confirmar contraseña"
        }
        updateMensajePassword(message)
        if(!message.contains("Error")){
            UserService2.updatePassword(id.value!!,newPassword.value!!)
            updatePassword("")
            updateNewPassword("")
            updateNewPasswordConfirm("")
        }
        Handler().postDelayed({
            updateMensajePassword("")
        }, 1000)
    }

    fun unsetUser(){
        this.updateUser("")
        this.updateName("")
        this.updateMail("")
        this.updateUrl("")
    }
}
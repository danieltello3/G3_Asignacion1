package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.services.UserService

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

    fun getUser(id: Int){
        val user: User = UserService.fetchOne(id)
        if(user != null){
            this.updateUser(user.usuario)
            this.updateName(user.nombre)
            this.updateMail(user.correo)
            this.updateUrl(user.imagen)
            this.updateId(user.id)
        }
    }

    fun validar(context: Context){
        val message: String = UserService.existData(mail.value!!,user.value!!,id.value!!)
        if(message != "OK"){
            updateMensaje("Error: $message")
        }else{
            updateMensaje("Perfil Editado")
        }
    }

    fun validarOldPassword(context: Context) {
        val res: Boolean = UserService.validatePassword(id.value!!, password.value!!)
        if(res){
            updateMensajePassword("Error: Contraseña antigua no coincide")
        }
    }

    fun unsetUser(){
        this.updateUser("")
        this.updateName("")
        this.updateMail("")
        this.updateUrl("")
    }
}
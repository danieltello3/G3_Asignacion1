package pe.edu.grupo3_asignacion1.ui.asignacion1.perfilModules.viewmodels

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
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.activities.AppActivity
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.models.requests.PasswordUpdate
import pe.edu.grupo3_asignacion1.models.requests.PasswordValidate
import pe.edu.grupo3_asignacion1.models.requests.UserUpdate
import pe.edu.grupo3_asignacion1.models.requests.UserValidate
import pe.edu.grupo3_asignacion1.services.IUserService
import pe.edu.grupo3_asignacion1.services.UserService
import pe.edu.ulima.dbaccess.configs.BackendClient
import pe.edu.ulima.dbaccess.configs.LocalDB

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

    fun getUser(context: Context, id: Int){
        //val user: User = UserService.fetchOne(id)
        viewModelScope.launch {
            try{
                withContext(Dispatchers.IO){
                    Log.v("GET USER","entra")
                    val database = LocalDB.getDatabase(context)
                    val userDao = database.userDao()
                    val user: User? = userDao.get(id)
                    if(user != null){
                        withContext(Dispatchers.Main){
                            updateUser(user.usuario)
                            updateName(user.nombre!!)
                            updateMail(user.correo)
                            updateUrl(user.imagen)
                            updateId(user.id)
                        }
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
                Log.v("GET USER",e.message.toString())
                val activity: Activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, No se obtener usuario de bd local",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    //NEW EDITAR PERFIL
    public fun UpdateUser(context: Context) {
        viewModelScope.launch {
            val apiService = BackendClient.buildService(IUserService::class.java)
            val database = LocalDB.getDatabase(context)
            val userDao = database.userDao()
            try {
                withContext(Dispatchers.IO) {
                    val localRes = userDao.validateUser(id.value!!, user.value!!, mail.value!!)
                    if (localRes == null) {
                        val bodyValidate = UserValidate(id.value!!, user.value!!, mail.value!!)
                        val serviceRes = apiService.validateUnique(bodyValidate)
                        if (serviceRes.code() == 200) {
                            if (serviceRes.body()?.status == "OK") {
                                //Se actualiza en el Servidor
                                val body =
                                    UserUpdate(id.value!!, user.value!!, name.value!!, mail.value!!)
                                val response = apiService.updateUser(body)
                                if (response.code() == 200) {
                                    //se actualiza en Local
                                    val res = userDao.update(
                                        id.value!!,
                                        user.value!!,
                                        name.value!!,
                                        mail.value!!
                                    )
                                    if(res == 1){
                                        updateMensaje("Perfil Editado")
                                    }
                                } else if (response.code() == 500) {
                                    updateMensaje("Error:Usuario y contraseña no válidos")
                                } else {
                                    updateMensaje("Error:Ocurrió un error no esperado")
                                }
                            } else {
                                updateMensaje(serviceRes.body()?.message!!)
                            }
                        } else if (serviceRes.code() == 500) {
                            updateMensaje("Error:Error al actualizar usuario")
                        } else {
                            updateMensaje("Error:Ocurrió un error no esperado")
                        }
                    } else {
                        if (localRes.usuario == user.value!!) {
                            updateMensaje("Error:El usuario ya existe")
                        } else if (localRes.correo == mail.value!!) {
                            updateMensaje("Error:El correo ya existe")
                        }
                    }
                    val activity = context as Activity
                    activity.runOnUiThread {
                        Handler().postDelayed({
                            updateMensaje("")
                        }, 2000)
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
                println("1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
                Log.v("Exception", e.message!!)
                println("2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
                val activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, No se pudo validar el usuario",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    // NEW CHANGE PASSWORD
    public fun changePassword(context: Context){
        viewModelScope.launch {
            val apiService = BackendClient.buildService(IUserService::class.java)
            val database = LocalDB.getDatabase(context)
            val userDao = database.userDao()
            try{
                withContext(Dispatchers.IO){
                    //VALIDACIONES
                    val bodyValidate = PasswordValidate(id.value!!,password.value!!)
                    val valResponse = apiService.validatePassword(bodyValidate)
                    if(valResponse.code() == 200){
                        if(valResponse.body()?.status == "OK"){
                            if(newPassword.value != newPasswordConfirm.value){
                                updateMensajePassword("Error: La nueva contraseña no coincide con confirmar contraseña")
                            }else{
                                //CAMBIO DE PASSWORD SERVIDOR
                                val body = PasswordUpdate(id.value!!,newPassword.value!!)
                                val response = apiService.updatePassword(body)
                                if(response.code() == 200){
                                    //CAMBIO DE PASSWORD LOCAL
                                    val daoResponse = userDao.updatePassword(id.value!!,newPassword.value!!)
                                    if(daoResponse == 1) {
                                        updateMensajePassword("Contraseña actualizada")
                                    }
                                }else{
                                    updateMensajePassword("Error: Ocurrió un error no esperado")
                                }
                            }
                        }else{
                            updateMensajePassword(valResponse.body()?.message!!)
                        }
                    }else{
                        updateMensajePassword("Ocurrió un error no esperado")
                    }

                    val activity = context as Activity
                    activity.runOnUiThread{
                        Handler().postDelayed({
                            updateMensajePassword("")
                        }, 2000)
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
                println("1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
                Log.v("Exception",e.message!!)
                println("2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
                val activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, No se pudo cambiar la contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun unsetUser(){
        this.updateUser("")
        this.updateName("")
        this.updateMail("")
        this.updateUrl("")
    }
}
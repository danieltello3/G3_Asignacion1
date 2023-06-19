package pe.edu.grupo3_asignacion1.ui.login.viewmodels

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.grupo3_asignacion1.configs.LocalDB

class SplashViewModel: ViewModel() {
    fun checkUser(context: Context, navController: NavHostController){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val database = LocalDB.getDatabase(context)
                    val userDao = database.userDao()
                    val userCount: Int? = userDao.getUserCount()
                    if (userCount != 0) {
                        // hay un usuario en db
                        withContext(Dispatchers.Main) {
                            navController.navigate("/profile")
                        }
                    } else {
                        // no hay un usuario en db
                        withContext(Dispatchers.Main) {
                            navController.navigate("/login")
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                val activity: Activity = context as Activity
                activity.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "Error, No se validar si hay alguien logueado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.configs.BackendClient
import pe.edu.grupo3_asignacion1.models.Follows
import pe.edu.grupo3_asignacion1.services.FollowerService
import pe.edu.grupo3_asignacion1.services.UserService
import kotlin.concurrent.thread

class FollowViewModel: ViewModel() {
    private val _followers = mutableStateOf<List<Follows>?>(
        listOf()
    )
    val followers get() = _followers.value
    fun setFollowers(userId: Int) {
        val apiService = BackendClient.buildService(FollowerService::class.java)
        thread {
            try {
                val response = apiService.fetchFollower(userId).execute()
                if(response.isSuccessful){
                    _followers.value = response.body()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
    private val _followings = mutableStateOf<List<Follows>?>(
        listOf()
    )
    val followings get() = _followings.value
    fun setFollowings(userId: Int) {
        val apiService = BackendClient.buildService(FollowerService::class.java)
        thread {
            try {
                val response = apiService.fetchFollowing(userId).execute()
                if(response.isSuccessful){
                    println(response.body())
                    _followings.value = response.body()
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
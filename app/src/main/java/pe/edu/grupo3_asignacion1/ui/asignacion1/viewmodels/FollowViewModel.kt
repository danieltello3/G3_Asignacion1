package pe.edu.grupo3_asignacion1.ui.asignacion1.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.grupo3_asignacion1.models.User
import pe.edu.grupo3_asignacion1.services.FollowerService
import pe.edu.grupo3_asignacion1.services.UserService

class FollowViewModel: ViewModel() {
    private val _id = MutableLiveData(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _user = MutableLiveData("")
    var user: LiveData<String> = _user
    fun updateUser(it: String){
        _user.postValue(it)
    }

    private val _followers = mutableStateOf<List<User>?>(
        listOf()
    )
    val followers get() = _followers.value
    fun setFollowers(userId: Int) {
        _user.value = UserService.fetchOne(userId).usuario
        _followers.value = FollowerService.fetchFollowers(userId)
    }
    private val _followings = mutableStateOf<List<User>?>(
        listOf()
    )
    val followings get() = _followings.value
    fun setFollowings(userId: Int) {
        _user.value = UserService.fetchOne(userId).usuario
        _followings.value = FollowerService.fetchFollowings(userId)
    }
}
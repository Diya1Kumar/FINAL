import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    // MutableLiveData to hold user data
    private val _user = MutableLiveData<User?>() // Assuming User is your data class
    val user: LiveData<User?> = _user

    fun fetchUser(email: String) {
        viewModelScope.launch {
            val fetchedUser = userDao.getUserByEmail(email)
            _user.postValue(fetchedUser) // Update LiveData with the fetched user
        }
    }
}

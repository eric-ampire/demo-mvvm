package org.ericampire.android.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.ericampire.android.demo.model.GithubUser
import org.ericampire.android.demo.model.GithubUserDao
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.*


// Pour utiliser KoinComponent pour avoir access a by inject
class UserViewModel : ViewModel(), KoinComponent {

    // Injection du dao
    private val dao by inject<GithubUserDao>()

    // REcuperationd des donnees
    val data: LiveData<List<GithubUser>> = dao.getAll()


    fun addRandomData() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            for (index in 2..5) {
                val randomId = Random().nextLong()
                val user = GithubUser(randomId, "Nom $randomId", "Login $randomId")
                dao.add(user)
            }
        }
    }
}
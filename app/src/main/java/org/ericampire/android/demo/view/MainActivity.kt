package org.ericampire.android.demo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import org.ericampire.android.demo.R
import org.ericampire.android.demo.model.GithubUser
import org.ericampire.android.demo.model.UserDatabase
import org.ericampire.android.demo.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Injection du viewModel
    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Observationd des donnees
        userViewModel.data.observe(this, Observer {
            for (item in it) {
                Log.e("ericampire", item.toString())
            }
        })

        btnRandomData.setOnClickListener {
            userViewModel.addRandomData()
        }
    }
}

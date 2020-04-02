package org.ericampire.android.demo.app

import androidx.room.Room
import org.ericampire.android.demo.model.GithubUserDao
import org.ericampire.android.demo.model.UserDatabase
import org.ericampire.android.demo.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserViewModel() }
}

val databaseModule = module {
    single<UserDatabase> {
        Room.databaseBuilder(androidApplication(), UserDatabase::class.java, "user.db")
            .allowMainThreadQueries()
            .build()
    }

    single<GithubUserDao> {
        get<UserDatabase>().userDao()
    }
}
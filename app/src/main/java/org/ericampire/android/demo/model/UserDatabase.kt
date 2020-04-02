package org.ericampire.android.demo.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GithubUser::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): GithubUserDao
}
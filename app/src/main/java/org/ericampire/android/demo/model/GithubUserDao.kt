package org.ericampire.android.demo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GithubUserDao {
    @Insert
    fun add(user: GithubUser)

    @Query("SELECT * FROM GithubUser")
    fun getAll(): LiveData<List<GithubUser>>

    @Delete
    fun remove(user: GithubUser)
}
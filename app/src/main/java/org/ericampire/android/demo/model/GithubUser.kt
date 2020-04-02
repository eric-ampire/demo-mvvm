package org.ericampire.android.demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUser(
    @PrimaryKey val id: Long,
    val avatar_url: String,
    val login: String
)
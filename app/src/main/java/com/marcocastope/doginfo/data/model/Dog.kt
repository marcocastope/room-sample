package com.marcocastope.doginfo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs")
data class Dog(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val breed: String? = null,
    val description: String? = null,
    val posterPath: String? = null
)

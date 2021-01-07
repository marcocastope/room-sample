package com.marcocastope.doginfo.data.dao

import androidx.room.*
import com.marcocastope.doginfo.data.model.Dog

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDog(dog: Dog)

    @Query("SELECT id, breed, description, posterPath FROM dogs ORDER BY id")
    suspend fun getDogs(): List<Dog>

    @Query("SELECT id, breed, description, posterPath FROM DOGS WHERE id = :dogId")
    suspend fun getDog(dogId: Int): Dog

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateDog(dog: Dog)

    @Delete
    suspend fun removeDog(dog: Dog)
}
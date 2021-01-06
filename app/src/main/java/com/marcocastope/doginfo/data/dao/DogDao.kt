package com.marcocastope.doginfo.data.dao

import androidx.room.*
import com.marcocastope.doginfo.data.model.Dog

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDog(dog: Dog)

    @Query("SELECT id, breed, description, posterPath FROM dogs ORDER BY id")
    fun getDogs(): List<Dog>

    @Query("SELECT id, breed, description, posterPath FROM DOGS WHERE id = :dogId")
    fun getDog(dogId: Int): Dog

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateDog(dog: Dog)

    @Delete
    fun removeDog(dog: Dog)
}
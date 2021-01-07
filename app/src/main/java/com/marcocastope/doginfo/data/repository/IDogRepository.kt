package com.marcocastope.doginfo.data.repository

import com.marcocastope.doginfo.data.model.Dog

interface IDogRepository {
    suspend fun addDog(dog: Dog)

    suspend fun getDogs(): List<Dog>

    suspend fun getDog(dogId: Int): Dog

    suspend fun updateDog(dog: Dog)

    suspend fun removeDog(dog: Dog)
}
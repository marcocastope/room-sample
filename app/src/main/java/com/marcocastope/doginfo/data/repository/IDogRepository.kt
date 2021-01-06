package com.marcocastope.doginfo.data.repository

import com.marcocastope.doginfo.data.model.Dog

interface IDogRepository {
    fun addDog(dog: Dog)

    fun getDogs(): List<Dog>

    fun getDog(dogId: Int): Dog

    fun updateDog(dog: Dog)

    fun removeDog(dog: Dog)
}
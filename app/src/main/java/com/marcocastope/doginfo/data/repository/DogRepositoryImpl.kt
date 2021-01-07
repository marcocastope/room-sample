package com.marcocastope.doginfo.data.repository

import com.marcocastope.doginfo.data.dao.DogDao
import com.marcocastope.doginfo.data.model.Dog

class DogRepositoryImpl(private val dogDao: DogDao) : IDogRepository {

    override suspend fun addDog(dog: Dog) = dogDao.addDog(dog)

    override suspend fun getDogs(): List<Dog> = dogDao.getDogs()

    override suspend fun getDog(dogId: Int): Dog = dogDao.getDog(dogId)

    override suspend fun updateDog(dog: Dog) = dogDao.updateDog(dog)

    override suspend fun removeDog(dog: Dog) = dogDao.removeDog(dog)
}
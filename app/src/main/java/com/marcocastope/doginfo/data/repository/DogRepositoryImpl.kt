package com.marcocastope.doginfo.data.repository

import com.marcocastope.doginfo.data.dao.DogDao
import com.marcocastope.doginfo.data.model.Dog

class DogRepositoryImpl(private val dogDao: DogDao) : IDogRepository {

    override fun addDog(dog: Dog) = dogDao.addDog(dog)

    override fun getDogs(): List<Dog> = dogDao.getDogs()

    override fun getDog(dogId: Int): Dog = dogDao.getDog(dogId)

    override fun updateDog(dog: Dog) = dogDao.updateDog(dog)

    override fun removeDog(dog: Dog) = dogDao.removeDog(dog)
}
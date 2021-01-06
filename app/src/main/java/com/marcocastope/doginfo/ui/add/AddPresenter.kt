package com.marcocastope.doginfo.ui.add

import com.marcocastope.doginfo.data.model.Dog
import com.marcocastope.doginfo.data.repository.IDogRepository

class AddPresenter(private var view: AddContract.ViewInterface, private var localDataSource: IDogRepository)
    : AddContract.PresenterInterface {
    override fun addDog(breed: String, description: String, imageUrl: String) {
        if (breed.isNotEmpty() && description.isNotEmpty()) {
            val dog = Dog(breed = breed,
                    description = description,
                    posterPath = imageUrl)
            localDataSource.addDog(dog)
            view.returnToMain()
        } else {
            view.displayError("Please add data")
        }
    }
}
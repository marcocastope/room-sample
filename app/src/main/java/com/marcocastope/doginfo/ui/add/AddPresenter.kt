package com.marcocastope.doginfo.ui.add

import com.marcocastope.doginfo.data.model.Dog
import com.marcocastope.doginfo.data.repository.IDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AddPresenter(private var view: AddContract.ViewInterface,
                   private var localDataSource: IDogRepository,
                   private var lifecycleScope: CoroutineScope)
    : AddContract.PresenterInterface {
    override fun addDog(breed: String, description: String, imageUrl: String) {
        if (breed.isNotEmpty() && description.isNotEmpty()) {
            val dog = Dog(breed = breed,
                    description = description,
                    posterPath = imageUrl)
            lifecycleScope.launch {
                localDataSource.addDog(dog)
                view.returnToMain()
            }
        } else {
            view.displayError("Please add data")
        }
    }
}
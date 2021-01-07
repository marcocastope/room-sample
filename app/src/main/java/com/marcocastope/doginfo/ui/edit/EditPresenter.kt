package com.marcocastope.doginfo.ui.edit

import com.marcocastope.doginfo.data.model.Dog
import com.marcocastope.doginfo.data.repository.IDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class EditPresenter(private var view: EditContract.ViewInterface,
                    private var localDataSource: IDogRepository,
                    private var lifecycleScope: CoroutineScope)
    : EditContract.PresenterInterface {

    override fun getDog(id: Int) {
        lifecycleScope.launch {
            view.displayDog(localDataSource.getDog(id))
        }
    }

    override fun updateDog(id: Int, breed: String, description: String, imageUrl: String) {
        if (breed.isNotEmpty() && description.isNotEmpty() && imageUrl.isNotEmpty()) {
            lifecycleScope.launch {
                localDataSource.updateDog(Dog(id, breed, description, imageUrl))
                view.returnToMain()
            }
        } else {
            view.displayError("Please, insert data")
        }
    }


}
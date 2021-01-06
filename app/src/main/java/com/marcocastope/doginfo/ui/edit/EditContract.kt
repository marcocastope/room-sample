package com.marcocastope.doginfo.ui.edit

import com.marcocastope.doginfo.data.model.Dog

class EditContract {
    interface PresenterInterface {
        fun getDog(id: Int)
        fun updateDog(id: Int, breed: String, description: String, imageUrl: String)
    }

    interface ViewInterface {
        fun displayDog(dog: Dog)
        fun displayMessage(message: String)
        fun displayError(message: String)
        fun returnToMain()
    }
}
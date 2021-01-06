package com.marcocastope.doginfo.ui.add

class AddContract {
    interface PresenterInterface {
        fun addDog(breed: String, description: String, imageUrl: String)
    }

    interface ViewInterface {
        fun returnToMain()
        fun displayMessage(message: String)
        fun displayError(message: String)
    }
}
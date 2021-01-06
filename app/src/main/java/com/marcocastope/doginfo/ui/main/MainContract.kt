package com.marcocastope.doginfo.ui.main

import com.marcocastope.doginfo.data.model.Dog

class MainContract {

    interface PresenterInterface {
        fun getDogs()
    }

    interface ViewInterface {
        fun displayDogs(dogs: List<Dog>)
        fun displayMessage(message: String)
        fun displayError(message: String)
    }
}
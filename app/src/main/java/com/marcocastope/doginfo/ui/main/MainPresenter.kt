package com.marcocastope.doginfo.ui.main

import com.marcocastope.doginfo.data.repository.IDogRepository

class MainPresenter(private var view: MainContract.ViewInterface, private var localDataSource: IDogRepository)
    : MainContract.PresenterInterface{

    override fun getDogs() {
        view.displayDogs(localDataSource.getDogs())
    }
}
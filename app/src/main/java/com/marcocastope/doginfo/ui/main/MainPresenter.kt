package com.marcocastope.doginfo.ui.main

import com.marcocastope.doginfo.data.repository.IDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainPresenter(private var view: MainContract.ViewInterface,
                    private var localDataSource: IDogRepository,
                    private var lifecycleScope: CoroutineScope)
    : MainContract.PresenterInterface{

    override fun getDogs() {
        lifecycleScope.launch {
            view.displayDogs(localDataSource.getDogs())
        }
    }
}
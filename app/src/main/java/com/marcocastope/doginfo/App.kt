package com.marcocastope.doginfo

import android.app.Application
import com.marcocastope.doginfo.data.database.DogDatabase
import com.marcocastope.doginfo.data.repository.DogRepositoryImpl
import com.marcocastope.doginfo.data.repository.IDogRepository

class App : Application() {
    companion object {
        private lateinit var instance: App

        private val database: DogDatabase by lazy { DogDatabase.buildDatabase(instance) }

        val repository: IDogRepository by lazy { DogRepositoryImpl(database.dogDao()) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
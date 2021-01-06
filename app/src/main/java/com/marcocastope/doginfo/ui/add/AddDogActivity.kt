package com.marcocastope.doginfo.ui.add

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.marcocastope.doginfo.App
import com.marcocastope.doginfo.R
import com.marcocastope.doginfo.ui.toast

class AddDogActivity : AppCompatActivity(), AddContract.ViewInterface {

    private lateinit var addDogBreed: EditText
    private lateinit var addDogDescription: EditText
    private lateinit var addDogImageUrl: EditText
    private lateinit var addDogBtn: Button
    private lateinit var addPresenter: AddContract.PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_dog)
        initUi()
        setupPresenter()
        setupListeners()
    }

    private fun setupPresenter() {
        val localDataSource = App.repository
        addPresenter = AddPresenter(this, localDataSource)
    }

    private fun initUi() {
        supportActionBar?.title = "Add Dog"
        addDogBreed = findViewById(R.id.addDogBreed)
        addDogDescription = findViewById(R.id.addDogDescription)
        addDogImageUrl = findViewById(R.id.addDogImageUrl)
        addDogBtn = findViewById(R.id.addDogBtn)
    }

    private fun setupListeners() {
        addDogBtn.setOnClickListener {
            addPresenter.addDog(addDogBreed.text.toString(),
                                addDogDescription.text.toString(),
                                addDogImageUrl.text.toString())
        }
    }

    override fun returnToMain() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun displayMessage(message: String) {
        toast(message)
    }

    override fun displayError(message: String) {
        displayMessage(message)
    }
}
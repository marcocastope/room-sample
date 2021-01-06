package com.marcocastope.doginfo.ui.edit

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.marcocastope.doginfo.App
import com.marcocastope.doginfo.R
import com.marcocastope.doginfo.data.model.Dog
import com.marcocastope.doginfo.ui.toast

class EditDogActivity : AppCompatActivity(), EditContract.ViewInterface {

    companion object {
        const val ID = "EditDogActivity:id"
    }

    private lateinit var editDogBreed: EditText
    private lateinit var editDogDescription: EditText
    private lateinit var editDogImageUrl: EditText
    private lateinit var editDogBtn: Button
    private lateinit var editPresenter: EditContract.PresenterInterface
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_dog)
        initUi()
        setupPresenter()
        id = intent.getIntExtra(ID, -1)
        initListeners()
    }

    override fun onStart() {
        super.onStart()
        editPresenter.getDog(id)
    }

    private fun setupPresenter() {
        val localDataSource = App.repository
        editPresenter = EditPresenter(this, localDataSource)
    }

    private fun initUi() {
        supportActionBar?.title = "Edit Dog"
        editDogBreed = findViewById(R.id.editBreed)
        editDogDescription = findViewById(R.id.editDescription)
        editDogImageUrl = findViewById(R.id.editImageUrl)
        editDogBtn = findViewById(R.id.editDogBtn)
    }

    private fun initListeners() {
        editDogBtn.setOnClickListener {
            editPresenter.updateDog(id, editDogBreed.text.toString(),
                                    editDogDescription.text.toString(),
                                    editDogImageUrl.text.toString())
        }
    }

    override fun displayDog(dog: Dog) {
        editDogBreed.setText(dog.breed)
        editDogDescription.setText(dog.description)
        editDogImageUrl.setText(dog.posterPath)
    }

    override fun displayMessage(message: String) {
        toast(message)
    }

    override fun displayError(message: String) {
        displayMessage(message)
    }

    override fun returnToMain() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}
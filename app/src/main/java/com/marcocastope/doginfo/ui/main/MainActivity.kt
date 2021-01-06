package com.marcocastope.doginfo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.marcocastope.doginfo.App
import com.marcocastope.doginfo.R
import com.marcocastope.doginfo.data.model.Dog
import com.marcocastope.doginfo.ui.add.AddDogActivity
import com.marcocastope.doginfo.ui.edit.EditDogActivity
import com.marcocastope.doginfo.ui.startActivity
import com.marcocastope.doginfo.ui.toast

class MainActivity : AppCompatActivity(), MainContract.ViewInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private val adapter by lazy { DogListAdapter { startActivity<EditDogActivity>(EditDogActivity.ID to it.id) } }
    private lateinit var mainPresenter: MainContract.PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        setupPresenter()
        initListeners()
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.getDogs()
    }

    private fun setupPresenter() {
        val localDataSource = App.repository
        mainPresenter = MainPresenter(this, localDataSource)
    }

    private fun initUi() {
        recyclerView = findViewById(R.id.mainRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        swipeRefresh = findViewById(R.id.swipeRefresh)
        fab = findViewById(R.id.fab)
    }

    private fun initListeners() {
        fab.setOnClickListener { startActivity<AddDogActivity>() }
    }

    override fun displayDogs(dogs: List<Dog>) {
        adapter.setDogs(dogs)
    }

    override fun displayMessage(message: String) {
        toast(message)
    }

    override fun displayError(message: String) {
        displayMessage(message)
    }
}
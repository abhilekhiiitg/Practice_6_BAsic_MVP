package com.example.practice6.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practice6.MainApplication
import com.example.practice6.databinding.ActivityMainBinding
import com.example.practice6.presenter.UserPresenter
import javax.inject.Inject

class MainActivity : IUserView, AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as? MainApplication)?.component?.inject(this)
        presenter.attachView(this)
        loadData()
    }

    override fun loadData() {
        Log.d("Abhilekh", "inside loadData ")
        presenter.getData()
    }

    override fun showData() {
        Log.d("Abhilekh", "inside showData ")
    }
}
package com.example.practice6

import android.app.Application
import com.example.practice6.di.AppComponent
import com.example.practice6.di.DaggerAppComponent
import com.example.practice6.di.UserModule

class MainApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        component = DaggerAppComponent.builder()
            .userModule(UserModule(this))
            .build()
    }
}
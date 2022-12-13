package com.example.practice6.di

import com.example.practice6.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [UserModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
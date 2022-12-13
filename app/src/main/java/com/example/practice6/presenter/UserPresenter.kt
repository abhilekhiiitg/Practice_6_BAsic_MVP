package com.example.practice6.presenter

import android.util.Log
import com.example.practice6.repository.IUserRepository
import com.example.practice6.view.IUserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserPresenter @Inject constructor(private val userRepository: IUserRepository) : IUserPresenter {
    override var view: IUserView? = null

    override val disposable: CompositeDisposable = CompositeDisposable()

    override fun clearResources() {
        disposable.clear()
    }

    override fun getData() {
        Log.d("Abhilekh", "inside getData ")
        disposable.add(
            userRepository.getUserInfo(4231).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    view?.showData()
                    Log.d("Abhilekh", "success api - ${it.body().username}")
                },
                {
                    Log.d("Abhilekh", "error in  api - $it")
                })
        )
    }
}
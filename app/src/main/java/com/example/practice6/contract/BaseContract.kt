package com.example.practice6.contract

import io.reactivex.disposables.CompositeDisposable

interface BaseContract {

    interface BaseView

    interface BasePresenter<V : BaseView> {
        var view: V?
        val disposable: CompositeDisposable

        fun attachView(view: V) {
            this.view = view
        }

        fun deAttachView() {
            view = null
        }
    }
}
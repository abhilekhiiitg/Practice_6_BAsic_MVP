package com.example.practice6.presenter

import com.example.practice6.contract.BaseContract.BasePresenter
import com.example.practice6.view.IUserView

interface IUserPresenter : BasePresenter<IUserView> {

    fun clearResources()
    fun getData()

}
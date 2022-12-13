package com.example.practice6.view

import com.example.practice6.contract.BaseContract.BaseView

interface IUserView : BaseView {
    fun loadData()
    fun showData()
}
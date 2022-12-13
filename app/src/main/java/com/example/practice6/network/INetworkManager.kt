package com.example.practice6.network

import com.example.practice4.model.User
import io.reactivex.Single
import retrofit2.Response

interface INetworkManager {

    fun fetchUserInfoById(id: Int): Single<Response<User>>
}
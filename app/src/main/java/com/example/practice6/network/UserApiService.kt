package com.example.practice6.network

import com.example.practice4.model.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {

    @GET("{user}")
    fun getUser(@Path("user") user: Int): Single<Response<User>>
}
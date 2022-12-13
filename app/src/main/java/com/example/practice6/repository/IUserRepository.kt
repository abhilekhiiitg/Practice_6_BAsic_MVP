package com.example.practice6.repository

import com.example.practice4.model.User
import io.reactivex.Single
import retrofit2.Response

interface IUserRepository {
    fun getUserInfo(id: Int): Single<Response<User>>
}

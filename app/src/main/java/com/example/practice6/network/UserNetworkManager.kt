package com.example.practice6.network

import com.example.practice4.model.User
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class UserNetworkManager @Inject constructor(
    private val apiService: IApiService
) : INetworkManager {

    override fun fetchUserInfoById(id: Int): Single<Response<User>> {
        return apiService.getUser(id)
    }
}
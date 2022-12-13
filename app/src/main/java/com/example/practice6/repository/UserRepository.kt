package com.example.practice6.repository

import com.example.practice4.model.User
import com.example.practice6.network.INetworkManager
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userNetworkManager: INetworkManager
) : IUserRepository {

    override fun getUserInfo(id: Int): Single<Response<User>> {
        return userNetworkManager.fetchUserInfoById(id)
    }
}
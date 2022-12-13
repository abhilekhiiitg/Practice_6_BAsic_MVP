package com.example.practice6.di

import com.example.practice6.network.IApiService
import com.example.practice6.network.INetworkManager
import com.example.practice6.network.UserNetworkManager
import com.example.practice6.repository.IUserRepository
import com.example.practice6.repository.UserRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UserModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userNetworkManager: INetworkManager
    ): IUserRepository {
        return UserRepository(userNetworkManager)
    }

    @Provides
    @Singleton
    internal fun providesUserNetworkManager(
        githubApiService: IApiService
    ): INetworkManager {
        return UserNetworkManager(githubApiService)
    }

    @Provides
    @Singleton
    fun providesGithubApiService(retrofit: Retrofit): IApiService {
        return retrofit.create(IApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://gorest.co.in/public/v2/users/")
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }
}
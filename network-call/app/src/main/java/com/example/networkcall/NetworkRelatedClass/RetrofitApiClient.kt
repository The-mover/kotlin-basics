package com.example.networkcall.NetworkRelatedClass

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApiClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val retrofitService: ApiInterface by lazy {
        retrofit().create(ApiInterface::class.java)
    }
}
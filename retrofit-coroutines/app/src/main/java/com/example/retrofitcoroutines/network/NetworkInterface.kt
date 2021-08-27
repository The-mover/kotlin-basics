package com.example.retrofitcoroutines.network

import com.example.retrofitcoroutines.model.Comments
import retrofit2.http.GET

interface  NetworkInterface {
    @GET("comments")
    suspend fun getComments() : List<Comments>
}
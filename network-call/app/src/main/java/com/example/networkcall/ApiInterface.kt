package com.example.networkcall

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("posts")
    fun getData(): Call<List<MyDataItem>>

    @POST("posts")
    fun addPost(@Body myDataItem: MyDataItem): Call<MyDataItem>
}
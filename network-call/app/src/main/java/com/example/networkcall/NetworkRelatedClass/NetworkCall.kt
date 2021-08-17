package com.example.networkcall.NetworkRelatedClass


import com.example.networkcall.Model.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkCall : MyApiService {

    override fun getDataFromServer(callback: ResponseCallback<List<MyDataItem>>) {
        val retrofitService = RetrofitApiClient.retrofitService
        val retrofitData = retrofitService.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                if( responseBody.isNotEmpty() ) {
                    callback.onSuccess(responseBody)
                } else {
                    callback.onError(Exception("Empty List"))
                }
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                callback.onError(Exception("Empty List"))
            }
        })
    }

    override fun postDataToServer(myData: MyDataItem, callback: ResponseCallback<String>) {
        val retrofitService = RetrofitApiClient.retrofitService
        val retrofitData = retrofitService.addPost(myData)

        retrofitData.enqueue(object : Callback<MyDataItem?> {
            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                val responseBody = response.body()!!

                callback.onSuccess(responseBody.title)
            }

            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {
                callback.onError(Exception("Add Post Error"))
            }
        })
    }
}
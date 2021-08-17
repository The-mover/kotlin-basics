package com.example.networkcall.NetworkRelatedClass


import com.example.networkcall.Model.MyDataItem

interface MyApiService {
    fun getDataFromServer(callback: ResponseCallback<List<MyDataItem>>)
    fun postDataToServer(myData: MyDataItem, callback: ResponseCallback<String>)
}
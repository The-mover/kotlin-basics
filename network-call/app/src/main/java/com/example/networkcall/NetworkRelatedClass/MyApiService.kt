package com.example.networkcall.NetworkRelatedClass

import com.example.networkcall.Model.MyData
import com.example.networkcall.Model.MyDataItem

interface MyApiService {
    fun getDataFromServer(callback: ResponseCallback<String>)
    fun postDataToServer(myData: MyDataItem,callback: ResponseCallback<String>)
}
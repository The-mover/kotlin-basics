package com.example.networkcall.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.networkcall.Model.MyDataItem
import com.example.networkcall.NetworkRelatedClass.NetworkCall
import com.example.networkcall.NetworkRelatedClass.ResponseCallback
import com.example.networkcall.R


class MainActivity : AppCompatActivity() {

    private lateinit var getBtn: Button
    private lateinit var setBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBtn = findViewById(R.id.get_data_btn)
        setBtn = findViewById(R.id.post_data_btn)

        val myApiService = NetworkCall()

        getBtn.setOnClickListener {
            myApiService.getDataFromServer(object : ResponseCallback<String> {
                override fun onSuccess(data: String) {
                    showToast(data)
                }

                override fun onError(error: Throwable) {
                    showToast(error.toString())
                }
            })
        }

        setBtn.setOnClickListener {
            val myDataItem = MyDataItem("I am trying to make a post request", 101, "Post Request", 22)
            myApiService.postDataToServer(myDataItem, object : ResponseCallback<String> {
                override fun onSuccess(data: String) {
                    showToast(data)
                }

                override fun onError(error: Throwable) {
                    showToast(error.toString())
                }
            })
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}
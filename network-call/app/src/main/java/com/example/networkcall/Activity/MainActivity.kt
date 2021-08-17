package com.example.networkcall.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.networkcall.Model.MyDataItem
import com.example.networkcall.NetworkRelatedClass.NetworkCall
import com.example.networkcall.NetworkRelatedClass.ResponseCallback
import com.example.networkcall.R


class MainActivity : AppCompatActivity() {

    private lateinit var getBtn: Button
    private lateinit var setBtn: Button
    private lateinit var loadingProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBtn = findViewById(R.id.get_data_btn)
        setBtn = findViewById(R.id.post_data_btn)
        loadingProgressBar = findViewById(R.id.loading_progress_bar)

        loadingProgressBar.visibility = View.GONE

        val myApiService = NetworkCall()

        getBtn.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            myApiService.getDataFromServer(object : ResponseCallback<List<MyDataItem>> {
                override fun onSuccess(data: List<MyDataItem>) {
//                    showToast(data)
                    val intent = Intent(applicationContext, PostListActivity::class.java)
                    intent.putParcelableArrayListExtra("postList", ArrayList(data));
                    loadingProgressBar.visibility = View.GONE
                    startActivity(intent)
                }

                override fun onError(error: Throwable) {
                    showToast(error.toString())
                }
            })
        }

        setBtn.setOnClickListener {
            val intent = Intent(this, AddPostActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}
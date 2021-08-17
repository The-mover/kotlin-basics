package com.example.networkcall.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.networkcall.Model.MyDataItem
import com.example.networkcall.NetworkRelatedClass.NetworkCall
import com.example.networkcall.NetworkRelatedClass.ResponseCallback
import com.example.networkcall.R

class AddPostActivity : AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var bodyEditText: EditText
    private lateinit var submitBtn: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        titleEditText = findViewById(R.id.title_edittext)
        bodyEditText = findViewById(R.id.body_edittext)
        submitBtn = findViewById(R.id.submit_btn)
        progressBar = findViewById(R.id.loading_progress_bar2)

        progressBar.visibility = View.GONE
        val myApiService = NetworkCall()

        submitBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val title = titleEditText.text.toString()
            val body = bodyEditText.text.toString()

            if(title == null || title.length == 0 || body == null || body.length == 0) {
                progressBar.visibility = View.GONE
                showToast("Enter Valid Data")
            }

            else {
                val myDataItem =
                    MyDataItem(body, 101, title, 22)
                myApiService.postDataToServer(myDataItem, object : ResponseCallback<String> {
                    override fun onSuccess(data: String) {
                        progressBar.visibility = View.GONE
                        showToast("Added Successfully")
                    }

                    override fun onError(error: Throwable) {
                        progressBar.visibility = View.GONE
                        showToast(error.toString())
                    }
                })
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }
}
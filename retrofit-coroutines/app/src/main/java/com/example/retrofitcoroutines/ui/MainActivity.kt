package com.example.retrofitcoroutines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutines.R
import com.example.retrofitcoroutines.model.Comments
import com.example.retrofitcoroutines.network.CommentRetriever
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private val commentRetriever : CommentRetriever = CommentRetriever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)
        initRecyclerview()
        fetchComments()
    }

    private fun fetchComments() {

        val commentsFetchJob = Job()

        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
        }

        val scope = CoroutineScope(commentsFetchJob + Dispatchers.Main)

        scope.launch(errorHandler){

            //fetched data
            val commentResponse = commentRetriever.getComments()
            Log.d("MainActivity", "${commentResponse.size}")

            //render data in recyclerview
            renderData(commentResponse)
        }
    }

    private fun renderData(commentResponse: List<Comments>) {
        recyclerview.adapter = CommentsAdapter(commentResponse = commentResponse)
    }

    private fun initRecyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
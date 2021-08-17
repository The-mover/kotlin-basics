package com.example.networkcall.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.Adapter.MyAdapter
import com.example.networkcall.Model.MyDataItem
import com.example.networkcall.R

class PostListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postList: List<MyDataItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val postList : ArrayList<MyDataItem> = intent.getParcelableArrayListExtra("postList")!!
        recyclerView.adapter = MyAdapter(postList.toList())
    }
}
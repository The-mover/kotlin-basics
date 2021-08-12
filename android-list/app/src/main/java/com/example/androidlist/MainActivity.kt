package com.example.androidlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic1,
            R.drawable.pic2,
        )

        heading = arrayOf(
            "Biden aims to expand vaccines for adults and children",
            "Just got my first shot, helping the world to be a safer place",
            "Local trians to be suspended in Bengal from tomorrwo in view of covid-19",
            "Biden aims to expand vaccines for adults and children",
            "Just got my first shot, helping the world to be a safer place",
            "Local trians to be suspended in Bengal from tomorrwo in view of covid-19",
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        newsList = arrayListOf<News>()
        getUserData()
    }

    private fun getUserData() {
       for(i in imageId.indices) {
           val news = News(imageId[i], heading[i])
           newsList.add(news)
       }
        recyclerView.adapter = MyAdapter(newsList)
    }
}
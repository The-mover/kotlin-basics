package com.example.networkcall.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkcall.Model.MyDataItem
import com.example.networkcall.R

class MyAdapter(private val postList: List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
       val currentItem = postList[position]
        holder.postTitle.text = currentItem.title
        holder.postBody.text = currentItem.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle : TextView = itemView.findViewById(R.id.post_title)
        val postBody : TextView = itemView.findViewById(R.id.post_body)
    }
}
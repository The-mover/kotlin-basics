package com.example.retrofitcoroutines.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutines.R
import com.example.retrofitcoroutines.model.Comments
import org.w3c.dom.Text

class CommentsAdapter(private val commentResponse: List<Comments>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {
        return ViewHolder(itemView = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false))
    }

    override fun onBindViewHolder(holder: CommentsAdapter.ViewHolder, position: Int) {
        holder.bind(comment = commentResponse[position])
    }

    override fun getItemCount(): Int = commentResponse.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById<TextView>(R.id.name)
        val email : TextView = itemView.findViewById<TextView>(R.id.email)
        val body : TextView = itemView.findViewById<TextView>(R.id.body)

        fun bind(comment : Comments){

            name.text = comment.name
            email.text = comment.email
            body.text = comment.body
        }
    }
}
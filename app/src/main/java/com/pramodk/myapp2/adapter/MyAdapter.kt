package com.pramodk.myapp2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pramodk.myapp2.R
import com.pramodk.myapp2.model.Post

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //create a empty list
    private var list = emptyList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView_id = itemView.findViewById<TextView>(R.id.txt_id)
        var textView_user_id = itemView.findViewById<TextView>(R.id.txt_user_id)
        var textView_title = itemView.findViewById<TextView>(R.id.txt_title)
        var textView_body = itemView.findViewById<TextView>(R.id.txt_body)
        fun bind(post: Post) {
            textView_id.text = post.id.toString()
            textView_user_id.text = post.userId.toString()
            textView_title.text = post.title
            textView_body.text = post.body
        }
    }

    //create a function to pollute the rv with data
    fun setData(newList: List<Post>) {
        list = newList
        notifyDataSetChanged()
    }

}

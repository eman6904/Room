package com.example.roomdatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databaseitems.Post
import com.example.roomdatabase.databinding.PostItemBinding

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    var postsList:List<Post> =ArrayList()
    fun setPosts(list:List<Post>)
    {
        this.postsList=list
        notifyDataSetChanged()
    }
    inner class ViewHolder(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemBodyTextView = binding.itemBodyTextView
        var itemTitleTextView = binding.itemTitleTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item=postsList[position]
        holder.itemBodyTextView.text=item.body
        holder.itemTitleTextView.text=item.title
    }

    override fun getItemCount(): Int {
      return postsList.size
    }
}

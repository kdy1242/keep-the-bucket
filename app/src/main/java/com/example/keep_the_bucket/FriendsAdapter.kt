package com.example.keep_the_bucket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FriendsAdapter(private val context: Context) : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {

    var datas = mutableListOf<FriendsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_friends, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val profileImg : ImageView = itemView.findViewById(R.id.profile_img)

        fun bind(item: FriendsData) {
            Glide.with(context).load(item.img).into(profileImg)
        }
    }
}
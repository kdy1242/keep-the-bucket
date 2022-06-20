package com.example.keep_the_bucket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FriendsListAdapter(private val context: Context) : RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    var datas = mutableListOf<FriendsListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.friend_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val profileImg: ImageView = itemView.findViewById(R.id.profileImg)
        private val profileName: TextView = itemView.findViewById(R.id.profileName)
        private val profileEmail: TextView = itemView.findViewById(R.id.profileEmail)

        fun bind(item: FriendsListData) {
            Glide.with(context).load(item.img).into(profileImg)
            profileName.text = item.name
            profileEmail.text = item.email
        }
    }


}
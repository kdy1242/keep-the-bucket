package com.example.keep_the_bucket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeMainFriendsAdapter(private val context: Context) : RecyclerView.Adapter<HomeMainFriendsAdapter.ViewHolder>() {

    var datas = mutableListOf<HomeMainFriendsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_firends_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val profileImg: ImageView = itemView.findViewById(R.id.profileImg)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val check1: CheckBox = itemView.findViewById(R.id.check1)
        private val check2: CheckBox = itemView.findViewById(R.id.check2)

        fun bind(item: HomeMainFriendsData) {
            Glide.with(context).load(item.img).into(profileImg)
            name.text = item.name
            check1.text = item.check1
            check1.isChecked = item.setChecked1
            check2.text = item.check2
            check2.isChecked = item.setChecked2
        }
    }


}
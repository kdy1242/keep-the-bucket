package com.example.keep_the_bucket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView

class HomeMainMyListAdapter(private val context: Context) : RecyclerView.Adapter<HomeMainMyListAdapter.ViewHolder>() {

    var datas = mutableListOf<HomeMainMyListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_my_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val check: CheckBox = itemView.findViewById(R.id.check)

        fun bind(item: HomeMainMyListData) {
            check.text = item.check
            check.isChecked = item.setChecked
        }
    }


}
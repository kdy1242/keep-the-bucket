package com.example.keep_the_bucket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeShareListAdapter(private val context: Context) : RecyclerView.Adapter<HomeShareListAdapter.ViewHolder>() {

    var datas = mutableListOf<HomeShareListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_my_list, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.listTitle)
        private val date: TextView = itemView.findViewById(R.id.listDate)


        fun bind(item: HomeShareListData) {
            title.text = item.title
            date.text = item.date

        }
    }


}
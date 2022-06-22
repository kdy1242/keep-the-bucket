package com.example.keep_the_bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeMyListAdapter(private val myList: ArrayList<HomeMyListData>) : RecyclerView.Adapter<HomeMyListAdapter.ViewHolder>() {

    var datas = mutableListOf<HomeMyListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = myList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myList : HomeMyListData = myList[position]

        holder.title.text = myList.title
        holder.startDate.text = myList.startDate
        holder.endDate.text = myList.endDate
    }

    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = itemView.findViewById(R.id.listTitle)
        val startDate: TextView = itemView.findViewById(R.id.startDate)
        val endDate: TextView = itemView.findViewById(R.id.endDate)
    }

}

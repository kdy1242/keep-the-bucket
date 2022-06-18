package com.example.keep_the_bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyListAdapter(private val context: HomeFragment) : RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    var datalist = mutableListOf<MyListData>()

    inner class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val home_myList: TextView = itemView.findViewById(R.id.home_myList)
        private val home_myList_date: TextView = itemView.findViewById(R.id.home_myList_date)
        private val home_myList_people: TextView = itemView.findViewById(R.id.home_myList_people)
        private val home_myList_time: TextView = itemView.findViewById(R.id.home_myList_time)

        fun bind(myListData: MyListData){
            home_myList.text=myListData.my_list_title
            home_myList_date.text= myListData.my_list_date
            home_myList_people.text=myListData.my_list_people.toString()
            home_myList_time.text=myListData.my_list_time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_mylist, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}
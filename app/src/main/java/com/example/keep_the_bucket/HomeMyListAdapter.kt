package com.example.keep_the_bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeMyListAdapter(private val context: ArrayList<HomeMyListData>) : RecyclerView.Adapter<HomeMyListAdapter.ViewHolder>() {

    var datas = mutableListOf<HomeMyListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.listTitle)
        private val startDate: TextView = itemView.findViewById(R.id.startDate)
        private val endDate: TextView = itemView.findViewById(R.id.endDate)
        private val people: TextView = itemView.findViewById(R.id.listPeople)
        private val time: TextView = itemView.findViewById(R.id.time)

        fun bind(item: HomeMyListData) {
            title.text = item.title
            startDate.text = item.startDate
            endDate.text = item.endDate
            people.text = item.people.toString()
            time.text = item.time
        }
    }


}
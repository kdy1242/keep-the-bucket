package com.example.keep_the_bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class BingoListAdapter(private val bingoList: ArrayList<BingoListModel>) : RecyclerView.Adapter<BingoListAdapter.ViewHolder>() {

    var datas = mutableListOf<BingoListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bingo_list,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = bingoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val bingoList : BingoListModel = bingoList[position]
        holder.check.text = bingoList.bingoList
        holder.check.isChecked = bingoList.isChecked
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }

    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val check: CheckBox = itemView.findViewById(R.id.check)

    }

    interface ItemClickListener{
        fun onClick(view: View,position: Int)
    }

    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}
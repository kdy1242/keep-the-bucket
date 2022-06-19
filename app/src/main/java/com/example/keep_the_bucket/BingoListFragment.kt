package com.example.keep_the_bucket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_bingo_list.*

class BingoListFragment : Fragment(R.layout.fragment_bingo_list) {
    lateinit var BingoListAdapter: BingoListAdapter
    val listdatas = mutableListOf<BingoListData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bingo_list, container, false)
        val recyclerViewBingoList: RecyclerView = view.findViewById(R.id.recycler_bingo_list)

        BingoListAdapter = BingoListAdapter(requireContext())
        recyclerViewBingoList.adapter = BingoListAdapter

        listdatas.apply {
            add(BingoListData(check = "테스트", setChecked = false))
            add(BingoListData(check = "테스트", setChecked = false))

            BingoListAdapter.datas = listdatas
            BingoListAdapter.notifyDataSetChanged()

            Log.d("test", "list test")
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        add_list_btn.setOnClickListener {
            BingoListDialog(requireContext()).show()
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
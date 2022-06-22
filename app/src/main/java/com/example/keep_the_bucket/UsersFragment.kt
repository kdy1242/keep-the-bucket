package com.example.keep_the_bucket

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_users.*


class UsersFragment : Fragment(R.layout.fragment_users) {

    lateinit var friendsListAdapter: FriendsListAdapter
    val datas = mutableListOf<FriendsListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_users, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val spinner : Spinner = view.findViewById(R.id.spinner)

        friendsListAdapter = FriendsListAdapter(requireContext())
        recyclerView.adapter = friendsListAdapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        datas.apply {
            datas.clear()
            add(FriendsListData(img =  R.drawable.hyo, name = "김효정", email = "w2029@e-mirim.hs.kr"))
            add(FriendsListData(img =  R.drawable.hong, name = "홍해인", email = "w2020@e-mirim.hs.kr"))

            friendsListAdapter.datas = datas
            friendsListAdapter.notifyDataSetChanged()
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.itemList,
            R.layout.spinner_list
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(R.layout.spinner_list)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        return view
    }

}
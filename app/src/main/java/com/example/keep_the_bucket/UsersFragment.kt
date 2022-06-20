package com.example.keep_the_bucket

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

        friendsListAdapter = FriendsListAdapter(requireContext())
        recyclerView.adapter = friendsListAdapter


        datas.apply {
            add(FriendsListData(img = R.drawable.test_img1, name = "테스트", email = "nhsally@naver.com"))
            add(FriendsListData(img = R.drawable.test_img1, name = "테스트2", email = "nhsally@naver.com"))

            friendsListAdapter.datas = datas
            friendsListAdapter.notifyDataSetChanged()

        }

        return view
    }

}
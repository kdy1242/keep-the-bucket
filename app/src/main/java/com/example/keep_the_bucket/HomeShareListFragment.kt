package com.example.keep_the_bucket

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home_my_list.*

class HomeShareListFragment : Fragment(R.layout.fragment_home_share_list) {

    lateinit var homeShareListAdapter: HomeShareListAdapter
    val datas = mutableListOf<HomeShareListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_share_list, container, false)
        val spinner : Spinner = view.findViewById(R.id.spinner)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
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

        homeShareListAdapter = HomeShareListAdapter(requireContext())
        recyclerView.adapter = homeShareListAdapter


        datas.apply {
            add(HomeShareListData(title = "여름 미션", date = "22.06.01 - 22.08.31", people = 1, time = "1시간 전 수정됨"))

            homeShareListAdapter.datas = datas
            homeShareListAdapter.notifyDataSetChanged()

        }

        return view
    }


}
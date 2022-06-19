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

class HomeMyListFragment : Fragment(R.layout.fragment_home_my_list) {

    lateinit var homeMyListAdapter: HomeMyListAdapter
    val datas = mutableListOf<HomeMyListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_my_list, container, false)
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

        homeMyListAdapter = HomeMyListAdapter(requireContext())
        recyclerView.adapter = homeMyListAdapter


        datas.apply {
            add(HomeMyListData(title = "테스트", date = "20.03.04 - 23.04.23", people = 2, time = "39분 전 수정됨"))
            add(HomeMyListData(title = "테스트2", date = "20.04.12 - 22.04.12", people = 3, time = "1시간 전 수정됨"))

            homeMyListAdapter.datas = datas
            homeMyListAdapter.notifyDataSetChanged()

        }

        return view
    }


}
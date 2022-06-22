package com.example.keep_the_bucket

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home_my_list.*

class HomeMyListFragment : Fragment(R.layout.fragment_home_my_list) {
    lateinit var recyclerView: RecyclerView
    lateinit var homeMyListAdapter: HomeMyListAdapter
    lateinit var homeMyListArray: ArrayList<HomeMyListData>
    lateinit var fbFirestore : FirebaseFirestore
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_my_list, container, false)
        val spinner : Spinner = view.findViewById(R.id.spinner)
        val addList: ImageView = view.findViewById(R.id.addList)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        homeMyListArray = ArrayList<HomeMyListData>()

        homeMyListAdapter = HomeMyListAdapter(homeMyListArray)

        recyclerView.adapter = homeMyListAdapter

        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("list")
            .whereEqualTo("uid", auth.uid)
            .addSnapshotListener { value, error ->
                Log.d("test", "addSnapshotListener")
                if (value != null) {
                    homeMyListArray.clear()
                    for(dc in value) {
                        Log.d("test", "DocumentChange.Type.ADDED")
                        homeMyListArray.add(
                            HomeMyListData(
                                dc["uid"] as String,
                                dc["title"] as String,
                                dc["startDate"] as String,
                                dc["endDate"] as String,
                                people = "1",
                                time = "1시간 전 수정됨",
                            )
                        )
                        Log.d("test", "$homeMyListArray")
                    }
                }
                homeMyListAdapter.notifyDataSetChanged()
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

        addList.setOnClickListener{
            val intent = Intent(requireContext(), AddBucketList::class.java)
            startActivity(intent)
        }

        return view
    }


}
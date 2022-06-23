package com.example.keep_the_bucket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_bingo_list.*

class BingoListFragment : Fragment(R.layout.fragment_bingo_list) {
    lateinit var recyclerView: RecyclerView
    lateinit var bingoListAdapter: BingoListAdapter
    lateinit var bingoListArray: ArrayList<BingoListModel>
    lateinit var fbFirestore : FirebaseFirestore
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bingo_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_bingo_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        bingoListArray = ArrayList<BingoListModel>()

        bingoListAdapter = BingoListAdapter(bingoListArray)

        recyclerView.adapter = bingoListAdapter

        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("bingo_list")
            .whereEqualTo("uid", auth.uid)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener { value, error ->
                Log.d("test", "addSnapshotListener")
                if (value != null) {
                    bingoListArray.clear()
                    for(dc in value) {
                        Log.d("test", "DocumentChange.Type.ADDED")
                        var diary = ""
                        if(dc["diaryUID"] !is String){
                            diary = ""
                        }else{
                            diary = dc["diaryUID"].toString()
                        }
                        bingoListArray.add(
                            BingoListModel(
                                dc["uid"] as String,
                                dc["checked"] as Boolean,
                                dc["bingoList"] as String,
                                diaryUID = diary
                            )
                        )
                        Log.d("test", bingoListArray[0].bingoList)
                    }
                }

                bingoListAdapter.notifyDataSetChanged()
            }
//
//        val bingoFragment = BingoFragment()
//        val bundle = Bundle()
//        for ( i in 0..bingoListArray.size) {
//            bundle.putString("bingoList", bingoListArray[i].bingoList)
//        }
//        bingoFragment.arguments = bundle
//        activity?.supportFragmentManager!!.beginTransaction().add(R.id.fragment_container, bingoFragment).commit()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_list_btn.setOnClickListener {
            BingoListDialog(requireContext()).show()
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
package com.example.keep_the_bucket

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home_main.*


class HomeMainFragment : Fragment(R.layout.fragment_home_main) {

    lateinit var homeMainFriendsListAdapter: HomeMainFriendsAdapter
    val friendsdatas = mutableListOf<HomeMainFriendsData>()

    lateinit var recyclerViewBingoList: RecyclerView
    lateinit var bingoListAdapter: BingoListAdapter
    lateinit var bingoListArray: ArrayList<BingoListModel>
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
        val view = inflater.inflate(R.layout.fragment_home_main, container, false)
        val recyclerViewFriendsList: RecyclerView = view.findViewById(R.id.recyclerView_FriendsList)
        val mission: LinearLayout = view.findViewById(R.id.mission)

        recyclerViewBingoList = view.findViewById(R.id.recyclerView_MyBingoList)

        mission.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.container, HomeShareListFragment()).commit()
        }

        homeMainFriendsListAdapter = HomeMainFriendsAdapter(requireContext())
        recyclerViewFriendsList.adapter = homeMainFriendsListAdapter

        recyclerViewFriendsList.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        friendsdatas.apply {
            add(HomeMainFriendsData(img = R.drawable.hyo, name = "김효정", check1 = "가족들과 해외여행", setChecked1 = true, check2 = "취업하기", setChecked2 = true))
            add(HomeMainFriendsData(img = R.drawable.hong, name = "홍해인", check1 = "IT쇼 전시하기", setChecked1 = true, check2 = "결혼하기", setChecked2 = false))

            homeMainFriendsListAdapter.datas = friendsdatas
            homeMainFriendsListAdapter.notifyDataSetChanged()
        }

        recyclerViewBingoList = view.findViewById(R.id.recyclerView_MyBingoList)
        recyclerViewBingoList.layoutManager = LinearLayoutManager(context)
        recyclerViewBingoList.setHasFixedSize(true)

        bingoListArray = ArrayList<BingoListModel>()

        bingoListAdapter = BingoListAdapter(bingoListArray)

        recyclerViewBingoList.adapter = bingoListAdapter

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
                                diaryUID =  diary
                            )
                        )
                        Log.d("test", "$bingoListArray")
                    }
                }
                bingoListAdapter.notifyDataSetChanged()
            }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        my_bingo_list.setOnClickListener {
            replaceFragment(BucketListFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}


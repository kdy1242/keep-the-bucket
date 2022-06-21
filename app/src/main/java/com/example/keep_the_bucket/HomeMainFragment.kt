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
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home_main.*


class HomeMainFragment : Fragment(R.layout.fragment_home_main) {

    lateinit var bingoListAdapter: BingoListAdapter
    val listdatas = mutableListOf<BingoListData>()
    lateinit var homeMainFriendsListAdapter: HomeMainFriendsAdapter
    val friendsdatas = mutableListOf<HomeMainFriendsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_main, container, false)
        val recyclerViewBingoList: RecyclerView = view.findViewById(R.id.recyclerView_MyBingoList)
        val recyclerViewFriendsList: RecyclerView = view.findViewById(R.id.recyclerView_FriendsList)
        val mission: LinearLayout = view.findViewById(R.id.mission)

        mission.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.container, HomeShareListFragment()).commit()
        }

        bingoListAdapter = BingoListAdapter(requireContext())
        recyclerViewBingoList.adapter = bingoListAdapter

        homeMainFriendsListAdapter = HomeMainFriendsAdapter(requireContext())
        recyclerViewFriendsList.adapter = homeMainFriendsListAdapter

        recyclerViewFriendsList.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        listdatas.apply {
            add(BingoListData(check = "테스트", setChecked = false))
            add(BingoListData(check = "테스트", setChecked = false))

            bingoListAdapter.datas = listdatas
            bingoListAdapter.notifyDataSetChanged()


            Log.d("test", "list test home")

        }

        friendsdatas.apply {
            add(HomeMainFriendsData(img = R.drawable.ic_add_bingo_img_btn, name = "테스트", check1 = "테스트1", setChecked1 = false, check2 = "테스트2", setChecked2 = true))
            add(HomeMainFriendsData(img = R.drawable.test_img1, name = "테스트", check1 = "테스트1", setChecked1 = false, check2 = "테스트2", setChecked2 = true))

            homeMainFriendsListAdapter.datas = friendsdatas
            homeMainFriendsListAdapter.notifyDataSetChanged()

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


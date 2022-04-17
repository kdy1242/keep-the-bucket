package com.example.keep_the_bucket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.keep_the_bucket.databinding.FragmentBucketListBinding
import kotlinx.android.synthetic.main.fragment_bucket_list.*


class BucketListFragment : Fragment() {
    private lateinit var friendsAdapter: FriendsAdapter
    val datas = mutableListOf<FriendsData>()
    private lateinit var binding : FragmentBucketListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBucketListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsAdapter = FriendsAdapter(requireContext())
        binding.friendsRecycler.adapter = friendsAdapter
    }

    private fun initRecycler() {

        datas.apply {
            add(FriendsData(img = R.drawable.test_img1))
            add(FriendsData(img = R.drawable.test_img1))
            add(FriendsData(img = R.drawable.test_img1))

            friendsAdapter = FriendsAdapter(requireContext())
            friendsAdapter.datas = datas
            binding.friendsRecycler.adapter = friendsAdapter
            friendsAdapter.notifyDataSetChanged()

        }
    }
}
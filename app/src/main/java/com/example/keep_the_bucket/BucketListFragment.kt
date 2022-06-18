package com.example.keep_the_bucket

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.keep_the_bucket.databinding.FragmentBucketListBinding
import kotlinx.android.synthetic.main.fragment_bucket_list.*
import java.util.zip.Inflater


class BucketListFragment : Fragment() {
//    private lateinit var friendsAdapter: FriendsAdapter
//    val datas = mutableListOf<FriendsData>()
    lateinit var myFragment: View
    lateinit var viewPagers: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(binding.root)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myFragment = inflater.inflate(R.layout.fragment_bucket_list, container, false)
        return myFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setUpViewPager()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        viewPagers = viewPager

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(BingoFragment(), "bingo")
        adapter.addFragment(BingoListFragment(), "bingoList")

        viewPagers.adapter = adapter
    }

}
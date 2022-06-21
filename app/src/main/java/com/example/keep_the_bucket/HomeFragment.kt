package com.example.keep_the_bucket

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var tabLayout: TabLayout
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        tabLayout = view.findViewById(R.id.tabLayout)
        frameLayout = view.findViewById(R.id.container)

        parentFragmentManager.beginTransaction().replace(R.id.container, HomeMainFragment()).commit()

        tabLayout.setTabTextColors(Color.parseColor("#A0A0A0"),Color.parseColor("#F8BAA0"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#F8BAA0"));


        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {

            // 탭 버튼을 선택할 때 이벤트
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = parentFragmentManager.beginTransaction()
                when(tab?.text) {
                    "홈" -> transaction.replace(R.id.container, HomeMainFragment() )
                    "내 리스트" -> transaction.replace(R.id.container, HomeMyListFragment() )
                    "챌린지" -> transaction.replace(R.id.container, HomeShareListFragment() )
                }
                transaction.commit()
            }

            // 다른 탭 버튼을 눌러 선택된 탭 버튼이 해제될 때 이벤트
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            // 선택된 탭 버튼을 다시 선택할 때 이벤
            override fun onTabReselected(tab: TabLayout.Tab?) {
                val transaction = parentFragmentManager.beginTransaction()
                when(tab?.text) {
                    "홈" -> transaction.replace(R.id.container, HomeMainFragment() )
                    "내 리스트" -> transaction.replace(R.id.container, HomeMyListFragment() )
                    "공유 리스트" -> transaction.replace(R.id.container, HomeShareListFragment() )
                }
                transaction.commit()
            }
        })

        return view
    }
}
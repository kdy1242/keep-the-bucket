package com.example.keep_the_bucket

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_users.*


class UsersFragment : Fragment(R.layout.fragment_users) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_users, container, false)
        val userstaball : LinearLayout = view.findViewById(R.id.users_tab_all)
        val userstabshare : LinearLayout = view.findViewById(R.id.users_tab_share)
        val userstaballtext : TextView = view.findViewById(R.id.users_tab_all_text)
        val usertabsharetext : TextView = view.findViewById(R.id.users_tab_share_text)
        val userstaballview :View = view.findViewById(R.id.users_tab_all_view)
        val usertabshareview :View = view.findViewById(R.id.users_tab_share_view)
        val viewFlipper : ViewFlipper = view.findViewById(R.id.users_viewflipper)
        val userssearchimg : ImageView = view.findViewById(R.id.users_search_img)

        userstaball.setOnClickListener(){
            userstaballtext.setTextColor(Color.parseColor("#F8BAA0"))
            usertabsharetext.setTextColor(Color.parseColor("#868686"))
            userstaballview.visibility = View.VISIBLE
            usertabshareview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 0
        }

        userstabshare.setOnClickListener(){
            userstaballtext.setTextColor(Color.parseColor("#868686"))
            usertabsharetext.setTextColor(Color.parseColor("#F8BAA0"))
            userstaballview.visibility = View.INVISIBLE
            usertabshareview.visibility = View.VISIBLE
            viewFlipper.displayedChild = 1
        }

        userssearchimg.setOnClickListener(){
            val intent = Intent(activity, SearchUserActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}
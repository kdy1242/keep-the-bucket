package com.example.keep_the_bucket

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.core.content.ContextCompat


class HomeFragment : Fragment(R.layout.fragment_home) {

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
        val hometabhome :LinearLayout = view.findViewById(R.id.home_tab_home)
        val hometabsharelist :LinearLayout = view.findViewById(R.id.home_tab_sharelist)
        val hometabhometext :TextView = view.findViewById(R.id.home_tab_home_text)
        val hometabsharelisttext :TextView = view.findViewById(R.id.home_tab_sharelist_text)
        val hometabhomeview :View = view.findViewById(R.id.home_tab_home_view)
        val hometabsharelistview :View = view.findViewById(R.id.home_tab_sharelist_view)
        val viewFlipper :ViewFlipper = view.findViewById(R.id.home_viewflipper)
        val check1 :CheckBox = view.findViewById(R.id.home_mylist_check1)
        val check2 :CheckBox = view.findViewById(R.id.home_mylist_check2)
        val check3 :CheckBox = view.findViewById(R.id.home_mylist_check3)
        val friend1check1 :CheckBox = view.findViewById(R.id.home_friend1_check1)
        val friend1check2 :CheckBox = view.findViewById(R.id.home_friend1_check2)
        val friend2check1 :CheckBox = view.findViewById(R.id.home_friend2_check1)
        val friend2check2 :CheckBox = view.findViewById(R.id.home_friend2_check2)

        hometabhome.setOnClickListener(){
            hometabhometext.setTextColor(Color.parseColor("#F8BAA0"))
            hometabsharelisttext.setTextColor(Color.parseColor("#868686"))
            hometabhomeview.visibility = View.VISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 0
        }

        hometabsharelist.setOnClickListener(){
            hometabhometext.setTextColor(Color.parseColor("#868686"))
            hometabsharelisttext.setTextColor(Color.parseColor("#F8BAA0"))
            hometabhomeview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.VISIBLE
            viewFlipper.displayedChild = 1
        }

        check1.setOnClickListener(){
            if(check1.isChecked){
                check1.setTextColor(Color.parseColor("#868686"))
            }else{
                check1.setTextColor(Color.BLACK)
            }
        }

        check2.setOnClickListener(){
            if(check2.isChecked){
                check2.setTextColor(Color.parseColor("#868686"))
            } else{
                check2.setTextColor(Color.BLACK)
            }
        }

        check3.setOnClickListener(){
            if(check3.isChecked){
                check3.setTextColor(Color.parseColor("#868686"))
            }else{
                check3.setTextColor(Color.BLACK)
            }
        }

        friend1check1.setOnClickListener(){
            if(friend1check1.isChecked){
                friend1check1.setTextColor(Color.parseColor("#868686"))
            }else{
                friend1check1.setTextColor(Color.BLACK)
            }
        }

        friend1check2.setOnClickListener(){
            if(friend1check2.isChecked){
                friend1check2.setTextColor(Color.parseColor("#868686"))
            }else{
                friend1check2.setTextColor(Color.BLACK)
            }
        }

        friend2check1.setOnClickListener(){
            if(friend2check1.isChecked){
                friend2check1.setTextColor(Color.parseColor("#868686"))
            }else{
                friend2check1.setTextColor(Color.BLACK)
            }
        }

        friend2check2.setOnClickListener(){
            if(friend2check2.isChecked){
                friend2check2.setTextColor(Color.parseColor("#868686"))
            }else{
                friend2check2.setTextColor(Color.BLACK)
            }
        }

        return view
    }
}
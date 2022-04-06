package com.example.keep_the_bucket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.core.content.ContextCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var hometabhome = findViewById<LinearLayout>(R.id.home_tab_home)
        var hometabmylist = findViewById<LinearLayout>(R.id.home_tab_mylist)
        var hometabsharelist = findViewById<LinearLayout>(R.id.home_tab_sharelist)
        var hometabhometext = findViewById<TextView>(R.id.home_tab_home_text)
        var hometabmylisttext = findViewById<TextView>(R.id.home_tab_mylist_text)
        var hometabsharelisttext = findViewById<TextView>(R.id.home_tab_sharelist_text)
        var hometabhomeview = findViewById<View>(R.id.home_tab_home_view)
        var hometabmylistview = findViewById<View>(R.id.home_tab_mylist_view)
        var hometabsharelistview = findViewById<View>(R.id.home_tab_sharelist_view)
        var viewFlipper = findViewById<ViewFlipper>(R.id.home_viewflipper)
        var check1 = findViewById<CheckBox>(R.id.home_mylist_check1)
        var check2 = findViewById<CheckBox>(R.id.home_mylist_check2)
        var check3 = findViewById<CheckBox>(R.id.home_mylist_check3)
        var friend1check1 = findViewById<CheckBox>(R.id.home_friend1_check1)
        var friend1check2 = findViewById<CheckBox>(R.id.home_friend1_check2)
        var friend2check1 = findViewById<CheckBox>(R.id.home_friend2_check1)
        var friend2check2 = findViewById<CheckBox>(R.id.home_friend2_check2)
        var tabsetting = findViewById<LinearLayout>(R.id.tab_setting)

        hometabhome.setOnClickListener(){
            hometabhometext.setTextColor(ContextCompat.getColor(this, R.color.main_orange))
            hometabmylisttext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabsharelisttext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabhomeview.visibility = View.VISIBLE
            hometabmylistview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 0
        }

        hometabmylist.setOnClickListener(){
            hometabhometext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabmylisttext.setTextColor(ContextCompat.getColor(this, R.color.main_orange))
            hometabsharelisttext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabhomeview.visibility = View.INVISIBLE
            hometabmylistview.visibility = View.VISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 1
        }

        hometabsharelist.setOnClickListener(){
            hometabhometext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabmylisttext.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            hometabsharelisttext.setTextColor(ContextCompat.getColor(this, R.color.main_orange))
            hometabhomeview.visibility = View.INVISIBLE
            hometabmylistview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.VISIBLE
            viewFlipper.displayedChild = 2
        }

        check1.setOnClickListener(){
            if(check1.isChecked){
                check1.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                check1.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        check2.setOnClickListener(){
            if(check2.isChecked){
                check2.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            } else{
                check2.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        check3.setOnClickListener(){
            if(check3.isChecked){
                check3.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                check3.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        friend1check1.setOnClickListener(){
            if(friend1check1.isChecked){
                friend1check1.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                friend1check1.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        friend1check2.setOnClickListener(){
            if(friend1check2.isChecked){
                friend1check2.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                friend1check2.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        friend2check1.setOnClickListener(){
            if(friend2check1.isChecked){
                friend2check1.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                friend2check1.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        friend2check2.setOnClickListener(){
            if(friend2check2.isChecked){
                friend2check2.setTextColor(ContextCompat.getColor(this, R.color.text_gray))
            }else{
                friend2check2.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        tabsetting.setOnClickListener{
            var intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}
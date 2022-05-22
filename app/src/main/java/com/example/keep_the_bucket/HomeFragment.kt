package com.example.keep_the_bucket

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*


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
        val hometabmylist :LinearLayout = view.findViewById(R.id.home_tab_mylist)
        val hometabsharelist :LinearLayout = view.findViewById(R.id.home_tab_sharelist)
        val hometabhometext :TextView = view.findViewById(R.id.home_tab_home_text)
        val hometabmylisttext :TextView = view.findViewById(R.id.home_tab_mylist_text)
        val hometabsharelisttext :TextView = view.findViewById(R.id.home_tab_sharelist_text)
        val hometabhomeview :View = view.findViewById(R.id.home_tab_home_view)
        val hometabmylistview :View = view.findViewById(R.id.home_tab_mylist_view)
        val hometabsharelistview :View = view.findViewById(R.id.home_tab_sharelist_view)
        val viewFlipper :ViewFlipper = view.findViewById(R.id.home_viewflipper)
        val homelistviewFlipper :ViewFlipper = view.findViewById(R.id.home_list_viewFlipper)
        val check1 :CheckBox = view.findViewById(R.id.home_mylist_check1)
        val check2 :CheckBox = view.findViewById(R.id.home_mylist_check2)
        val check3 :CheckBox = view.findViewById(R.id.home_mylist_check3)
        val friend1check1 :CheckBox = view.findViewById(R.id.home_friend1_check1)
        val friend1check2 :CheckBox = view.findViewById(R.id.home_friend1_check2)
        val friend2check1 :CheckBox = view.findViewById(R.id.home_friend2_check1)
        val friend2check2 :CheckBox = view.findViewById(R.id.home_friend2_check2)
        val homesearchimg :ImageView = view.findViewById(R.id.home_search_img)
        val spinner :Spinner = view.findViewById(R.id.spinner)
        val spinner2 :Spinner = view.findViewById(R.id.spinner2)
        val morebtn1 :ImageView = view.findViewById(R.id.more_btn1)
        val morebtn2 :ImageView = view.findViewById(R.id.more_btn2)
        val morebtn3 :ImageView = view.findViewById(R.id.more_btn3)
        val morebtn01 :ImageView = view.findViewById(R.id.more_btn01)
        val morebtn02 :ImageView = view.findViewById(R.id.more_btn02)
        val morebtn03 :ImageView = view.findViewById(R.id.more_btn03)
        val morebtn04 :ImageView = view.findViewById(R.id.more_btn04)
        val homechooseall :LinearLayout = view.findViewById(R.id.home_choose_all)
        val homechooseshare :LinearLayout = view.findViewById(R.id.home_choose_share)
        val homechoosemission :LinearLayout = view.findViewById(R.id.home_choose_mission)
        val homechoosealltext :TextView = view.findViewById(R.id.home_choose_all_text)
        val homechoosesharetext :TextView = view.findViewById(R.id.home_choose_share_text)
        val homechoosemissiontext :TextView = view.findViewById(R.id.home_choose_mission_text)

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

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.itemList,
            R.layout.spinner_list
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(R.layout.spinner_list)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }

        hometabhome.setOnClickListener(){
            hometabhometext.setTextColor(parseColor("#F8BAA0"))
            hometabmylisttext.setTextColor(parseColor("#868686"))
            hometabsharelisttext.setTextColor(parseColor("#868686"))
            hometabhomeview.visibility = View.VISIBLE
            hometabmylistview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 0
        }

        hometabmylist.setOnClickListener(){
            hometabhometext.setTextColor(parseColor("#868686"))
            hometabmylisttext.setTextColor(parseColor("#F8BAA0"))
            hometabsharelisttext.setTextColor(parseColor("#868686"))
            hometabhomeview.visibility = View.INVISIBLE
            hometabmylistview.visibility = View.VISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 1
        }

        hometabsharelist.setOnClickListener(){
            hometabhometext.setTextColor(parseColor("#868686"))
            hometabmylisttext.setTextColor(parseColor("#868686"))
            hometabsharelisttext.setTextColor(parseColor("#F8BAA0"))
            hometabhomeview.visibility = View.INVISIBLE
            hometabmylistview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.VISIBLE
            viewFlipper.displayedChild = 2
        }

        homechooseall.setOnClickListener(){
            homechooseall.setBackgroundResource(R.drawable.round_main_orange)
            homechooseshare.setBackgroundResource(R.drawable.round_main_gray)
            homechoosemission.setBackgroundResource(R.drawable.round_main_gray)
            homechoosealltext.setTextColor(parseColor("#ffffff"))
            homechoosesharetext.setTextColor(parseColor("#797979"))
            homechoosemissiontext.setTextColor(parseColor("#797979"))
            homelistviewFlipper.displayedChild = 0
        }

        homechooseshare.setOnClickListener(){
            homechooseall.setBackgroundResource(R.drawable.round_main_gray)
            homechooseshare.setBackgroundResource(R.drawable.round_main_orange)
            homechoosemission.setBackgroundResource(R.drawable.round_main_gray)
            homechoosealltext.setTextColor(parseColor("#797979"))
            homechoosesharetext.setTextColor(parseColor("#ffffff"))
            homechoosemissiontext.setTextColor(parseColor("#797979"))
            homelistviewFlipper.displayedChild = 1
        }

        homechoosemission.setOnClickListener(){
            homechooseall.setBackgroundResource(R.drawable.round_main_gray)
            homechooseshare.setBackgroundResource(R.drawable.round_main_gray)
            homechoosemission.setBackgroundResource(R.drawable.round_main_orange)
            homechoosealltext.setTextColor(parseColor("#797979"))
            homechoosesharetext.setTextColor(parseColor("#797979"))
            homechoosemissiontext.setTextColor(parseColor("#ffffff"))
            homelistviewFlipper.displayedChild = 2
        }

        check1.setOnClickListener(){
            if(check1.isChecked){
                check1.setTextColor(parseColor("#868686"))
            }else{
                check1.setTextColor(Color.BLACK)
            }
        }

        check2.setOnClickListener(){
            if(check2.isChecked){
                check2.setTextColor(parseColor("#868686"))
            } else{
                check2.setTextColor(Color.BLACK)
            }
        }

        check3.setOnClickListener(){
            if(check3.isChecked){
                check3.setTextColor(parseColor("#868686"))
            }else{
                check3.setTextColor(Color.BLACK)
            }
        }

        friend1check1.setOnClickListener(){
            if(friend1check1.isChecked){
                friend1check1.setTextColor(parseColor("#868686"))
            }else{
                friend1check1.setTextColor(Color.BLACK)
            }
        }

        friend1check2.setOnClickListener(){
            if(friend1check2.isChecked){
                friend1check2.setTextColor(parseColor("#868686"))
            }else{
                friend1check2.setTextColor(Color.BLACK)
            }
        }

        friend2check1.setOnClickListener(){
            if(friend2check1.isChecked){
                friend2check1.setTextColor(parseColor("#868686"))
            }else{
                friend2check1.setTextColor(Color.BLACK)
            }
        }

        friend2check2.setOnClickListener(){
            if(friend2check2.isChecked){
                friend2check2.setTextColor(parseColor("#868686"))
            }else{
                friend2check2.setTextColor(Color.BLACK)
            }
        }

        homesearchimg.setOnClickListener(){
            val intent = Intent(activity, SearchUserActivity::class.java)
            startActivity(intent)
        }

        morebtn1.setOnClickListener(){
            showPopup(morebtn1)
        }

        morebtn2.setOnClickListener(){
            showPopup(morebtn2)
        }

        morebtn3.setOnClickListener(){
            showPopup(morebtn3)
        }

        morebtn01.setOnClickListener(){
            showPopup(morebtn01)
        }

        morebtn02.setOnClickListener(){
            showPopup(morebtn02)
        }

        morebtn03.setOnClickListener(){
            showPopup(morebtn03)
        }

        morebtn04.setOnClickListener(){
            showPopup(morebtn04)
        }

        return view
    }
    fun showPopup(v: View) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.popup_menu, popup.menu)
        popup.show()
    }
}
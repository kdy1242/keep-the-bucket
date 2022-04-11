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
        val homesearchimg :ImageView = view.findViewById(R.id.home_search_img)
        val spinner :Spinner = view.findViewById(R.id.spinner)
        val morebtn1 :ImageView = view.findViewById(R.id.more_btn1)
        val morebtn2 :ImageView = view.findViewById(R.id.more_btn2)
        val morebtn3 :ImageView = view.findViewById(R.id.more_btn3)
        val morebtn4 :ImageView = view.findViewById(R.id.more_btn4)
        val morebtn5 :ImageView = view.findViewById(R.id.more_btn5)

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

        hometabhome.setOnClickListener(){
            hometabhometext.setTextColor(parseColor("#F8BAA0"))
            hometabsharelisttext.setTextColor(parseColor("#868686"))
            hometabhomeview.visibility = View.VISIBLE
            hometabsharelistview.visibility = View.INVISIBLE
            viewFlipper.displayedChild = 0
        }

        hometabsharelist.setOnClickListener(){
            hometabhometext.setTextColor(parseColor("#868686"))
            hometabsharelisttext.setTextColor(parseColor("#F8BAA0"))
            hometabhomeview.visibility = View.INVISIBLE
            hometabsharelistview.visibility = View.VISIBLE
            viewFlipper.displayedChild = 1
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

        morebtn4.setOnClickListener(){
            showPopup(morebtn4)
        }

        morebtn5.setOnClickListener(){
            showPopup(morebtn5)
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
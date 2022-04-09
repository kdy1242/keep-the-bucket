package com.example.keep_the_bucket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.EditorInfo
import android.widget.*

class SearchUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)
        val searchuserback = findViewById<ImageView>(R.id.search_user_back)
        val searchedit = findViewById<EditText>(R.id.search_edit)
        val searchimg = findViewById<ImageView>(R.id.search_img)
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)

        searchuserback.setOnClickListener(){
            finish()
        }

        searchedit.setOnEditorActionListener{v, id, event ->
            if(id == EditorInfo.IME_ACTION_SEARCH){
                viewFlipper.displayedChild = 1
            }
            true
        }

        searchimg.setOnClickListener(){
            viewFlipper.displayedChild = 1
        }
    }
}
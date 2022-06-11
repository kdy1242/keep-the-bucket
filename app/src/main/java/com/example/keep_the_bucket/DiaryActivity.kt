package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        var backbtn = findViewById<ImageView>(R.id.back_btn)

        backbtn.setOnClickListener {
            val intent = Intent(this, FragmentList::class.java)
            startActivity(intent)
        }







    }
}
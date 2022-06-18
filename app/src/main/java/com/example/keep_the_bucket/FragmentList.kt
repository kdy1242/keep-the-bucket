package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FragmentList : AppCompatActivity() {
    override fun onCreate(savedInstancState: Bundle?) {
        super.onCreate(savedInstancState)
        setContentView(R.layout.fragment_bucket_list)

        var ImgPlus1 = findViewById<ImageView>(R.id.ImgPlus1)

        ImgPlus1.setOnClickListener {
            val intent = Intent (this, DiaryActivity::class.java)
            startActivity(intent)
        }
    }
}



package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.keep_the_bucket.databinding.ActivityDiaryResultBinding
import com.google.firebase.firestore.FirebaseFirestore

class DiaryResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiaryResultBinding
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bingoNum = intent.getIntExtra("bingoNum",1)

        binding.backBtn.setOnClickListener {
            val intent = Intent(this,BingoFragment::class.java)
            startActivity(intent)
        }

    }

    private fun queryItem(bingoNum: String) {

        db.document(bingoNum.toString()).get()
            .addOnSuccessListener { // it: DocumentSnapshot
                Glide.with(this)
                    .load(it["imgUrl"] as String)
                    .into(binding.diaryImg)
                binding.diaryDateTxt.setText(it["timestamp"].toString())
                binding.diaryTitleTxt.setText(it["title"].toString())
                binding.diaryContents.setText(it["diary_cont"].toString())

            }.addOnFailureListener {
                Log.d("db","저장을 하지 못했습니다.")
            }
    }

}
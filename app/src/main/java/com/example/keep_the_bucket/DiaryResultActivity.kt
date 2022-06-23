package com.example.keep_the_bucket

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

        val diaryID = intent.getStringExtra("diaryID")

        if (diaryID != null) {
            db.collection("diary").document(diaryID).get()
                .addOnSuccessListener { // it: DocumentSnapshot
                    binding.diaryDateTxt.setText(it["timestamp"].toString())
                    binding.diaryTitleTxt.setText(it["title"].toString())
                    binding.diaryContents.setText(it["diary_cont"].toString())

                    if (it["imgUrl"] as String? != null){
                        Log.i("TAG", "onCreate: 사진 결과 "+it["imgUrl"])
                        Glide.with(applicationContext)
                            .load(it["imgUrl"] as String)
                            .into(binding.diaryImg)
                    }
                }.addOnFailureListener {
                    Log.d("db","저장을 하지 못했습니다.")
                }
        }
        binding.backBtn.setOnClickListener {
            finish()
        }

    }

}
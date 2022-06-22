package com.example.keep_the_bucket

import android.Manifest
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.keep_the_bucket.databinding.ActivityAddBucketListBinding
import com.example.keep_the_bucket.databinding.ActivityDiaryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_diary.*
import java.text.SimpleDateFormat
import java.util.*

class AddBucketList : AppCompatActivity() {
    val storage = Firebase.storage("gs://keepthebucket.appspot.com/")
    var auth : FirebaseAuth? = null
    var fbFirestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bucket_list)

        val title = findViewById<EditText>(R.id.title);
        val startDate = findViewById<EditText>(R.id.startdate);
        val endDate = findViewById<EditText>(R.id.enddate);

        val cancle = findViewById<Button>(R.id.cancle)
        val ok = findViewById<Button>(R.id.ok)

        auth = Firebase.auth
        fbFirestore = FirebaseFirestore.getInstance()

        ok.setOnClickListener {
            var bucketListModel = BucketListModel()
            bucketListModel.uid = auth?.currentUser?.uid
            bucketListModel.title = title.text.toString()
            bucketListModel.startDate = startDate.text.toString()
            bucketListModel.endDate = endDate.text.toString()

            fbFirestore?.collection("list")?.document()?.set(bucketListModel)
            Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show()
            finish()
        }

       cancle.setOnClickListener{
            finish()
        }

    }


}


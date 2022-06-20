package com.example.keep_the_bucket

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.FirebaseDatabase

class AddBucketList : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    lateinit var dbHelper : DBHelper
    lateinit var db : SQLiteDatabase
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bucket_list)

        database = FirebaseDatabase.getInstance().getReference("user/")
        auth = FirebaseAuth.getInstance()

        dbHelper = DBHelper(this, "newdb.db", null, 1)
        db = dbHelper.writableDatabase

        val title = findViewById<EditText>(R.id.title);
        val startDate = findViewById<EditText>(R.id.startdate);
        val endDate = findViewById<EditText>(R.id.enddate);

        val cancle = findViewById<Button>(R.id.cancle)
        val ok = findViewById<Button>(R.id.ok)

        cancle.setOnClickListener{
            finish()
        }

        ok.setOnClickListener{
            var query = "SELECT * FROM User;"

            val cursor = db.rawQuery(query, null)

            while(cursor.moveToNext()) {
                val dbemail = cursor.getString(0)

                val key = dbemail.replace(".", "")

                val database : FirebaseDatabase = FirebaseDatabase.getInstance()
                val myRef : DatabaseReference = database.getReference("user/")

                val titleKey = title.text.toString().replace(" ", "");

                var list = JoinActivity.List(title.text.toString(), startDate.text.toString(), endDate.text.toString())

                myRef.child(key).child(titleKey).setValue(list);

                finish()
            }

        }

    }


}


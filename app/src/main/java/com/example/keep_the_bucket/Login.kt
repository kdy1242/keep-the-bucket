package com.example.keep_the_bucket

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    lateinit var dbHelper : DBHelper
    lateinit var db :SQLiteDatabase
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        database = FirebaseDatabase.getInstance().getReference("user/")
        auth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val btn = findViewById<Button>(R.id.btn)
        val join = findViewById<Button>(R.id.join)

        join.setOnClickListener{
            val intent = Intent (this, Join::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener{
            signinEmail()
        }

        dbHelper = DBHelper(this, "newdb.db", null, 1)
        db = dbHelper.writableDatabase

    }

    fun signinEmail() {
        auth?.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    // Login, 아이디와 패스워드가 맞았을 때
                    val id = email.text.toString().replace(".", "")
                    database = database.child(id)
                    database.get().addOnSuccessListener {
                        val v = it.value.toString()
                        val v1 = v.replace("{", "")
                        val v2 = v1.replace("}", "")
                        val v3 = v2.replace(",", "")
                        var v4 = v3.split(" ")

                        val name = v4[0].split("=")
                        val email = v4[1].split("=")
                        var query = "INSERT INTO User values('" + email[1] + "', '" + name[1] + "');"
                        db.execSQL(query)
                    }
                    moveMainPage(task.result?.user)
                } else {
                    // Show the error message, 아이디와 패스워드가 틀렸을 때
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun moveMainPage(user: FirebaseUser?) {
        // 파이어베이스 유저 상태가 있을 경우 다음 페이지로 넘어갈 수 있음
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}


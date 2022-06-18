package com.example.keep_the_bucket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Join : AppCompatActivity() {
    private var auth : FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_join)
        val btn = findViewById<Button>(R.id.btn)
        val signupName = findViewById<EditText>(R.id.edit_name)
        val signupID = findViewById<EditText>(R.id.edit_email)
        val signupPassword = findViewById<EditText>(R.id.edit_password)

        // 계정 생성 버튼
        btn.setOnClickListener {
            createAccount(signupName.text.toString(), signupID.text.toString(),signupPassword.text.toString())
        }

    }

    // 계정 생성
    private fun createAccount(name: String, email: String, password: String) {

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val database : FirebaseDatabase = FirebaseDatabase.getInstance()
                        val myRef : DatabaseReference = database.getReference("user/")

                        val id = email.replace(".", "")

                        var user = User(name, email)

                        myRef.child(id).setValue(user);

                        Toast.makeText(
                            this, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
    data class User(
        var name: String? = "",
        var email: String? = "",
    ){
        @Exclude
        fun toMap(): Map<String, Any?>{
            return mapOf(
                "name" to name,
                "email" to email
            )
        }
    }
}
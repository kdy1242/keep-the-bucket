package com.example.keep_the_bucket

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginCustom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val editText = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.btn)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    button.setClickable(true)
                    button.setBackgroundColor(Color.BLUE)
                } else {
                    button.setClickable(false)
                    button.setBackgroundColor(Color.GRAY)
                }
            }
        })
    }
}
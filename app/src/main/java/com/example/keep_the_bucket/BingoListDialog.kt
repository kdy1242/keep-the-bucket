package com.example.keep_the_bucket

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.keep_the_bucket.databinding.DialogBingoListBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_diary.*
import kotlinx.android.synthetic.main.dialog_bingo_list.*

class BingoListDialog(context: Context,) : Dialog(context) {

    private lateinit var binding: DialogBingoListBinding
    var auth : FirebaseAuth? = null
    var fbFirestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        fbFirestore = FirebaseFirestore.getInstance()

        binding = DialogBingoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        setCancelable(false)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        ok_btn.setOnClickListener {
            Log.d("test", "ok_btn.setOnClickListener")
            val bingoListModel = BingoListModel()
            bingoListModel.uid = auth?.currentUser?.uid
            bingoListModel.bingoList = bingo_list_text.text.toString()
            bingoListModel.check = false

            fbFirestore?.collection("bingo_list")?.document()?.set(bingoListModel)
            Toast.makeText(context, "업로드 중...", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        cancel_btn.setOnClickListener {
            Log.d("test", "cancel_btn.setOnClickListener")
            dismiss()
        }
    }
}
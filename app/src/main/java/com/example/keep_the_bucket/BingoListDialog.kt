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
import kotlinx.android.synthetic.main.dialog_bingo_list.*
import java.text.SimpleDateFormat
import java.util.*

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
            val nowTime = System.currentTimeMillis()
            val nowTimeDate = Date(nowTime)
            val timeDateFormat = SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale("ko", "KR"))

            bingoListModel.uid = auth?.currentUser?.uid
            bingoListModel.bingoList = bingo_list_text.text.toString()
            bingoListModel.isChecked = false
            bingoListModel.timestamp = timeDateFormat.format(nowTimeDate)
            bingoListModel.diaryUID = ""

            fbFirestore?.collection("bingo_list")?.document()?.set(bingoListModel)
            Toast.makeText(context, "등록 완료", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        cancel_btn.setOnClickListener {
            Log.d("test", "cancel_btn.setOnClickListener")
            dismiss()
        }
    }
}
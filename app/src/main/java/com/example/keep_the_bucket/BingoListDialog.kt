package com.example.keep_the_bucket

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.keep_the_bucket.databinding.DialogBingoListBinding

class BingoListDialog(
        context: Context,
    ) : Dialog(context) {

    private lateinit var binding: DialogBingoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogBingoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        setCancelable(false)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        okBtn.setOnClickListener {
            dismiss()
        }

        cancelBtn.setOnClickListener {
            dismiss()
        }
    }
}
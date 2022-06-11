package com.example.keep_the_bucket

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.diary_dialog.view.*


class FragmentList : AppCompatActivity() {
//    var auth : FirebaseAuth? = null
//    var firestore : FirebaseFirestore? = null
    override fun onCreate(savedInstancState: Bundle?) {
        super.onCreate(savedInstancState)
        setContentView(R.layout.fragment_bucket_list)

//        auth = Firebase.auth
//        firestore = FirebaseFirestore.getInstance()

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
    }

    fun showDialog1(view: View) {
        val myLayout = layoutInflater.inflate(R.layout.diary_dialog, null)
        val build = AlertDialog.Builder(view.context).apply {
            setView(myLayout)
        }
        val dialog = build.create()
        dialog.show()

        myLayout.ok_txt.setOnClickListener {
            val intent = Intent (this, DiaryActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }
        myLayout.cancel_txt.setOnClickListener {
            dialog.dismiss()
        }
    }
//    data class ResultDTO(
//        var uid : String? = null,
//        var title: String? = null,
//        var sysdate: String?= null,
//    )
}



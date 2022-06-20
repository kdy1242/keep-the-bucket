package com.example.keep_the_bucket

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_diary.*


class DiaryActivity : AppCompatActivity() {
    val storage = Firebase.storage("gs://keepthebucket.appspot.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        diary_img.setOnClickListener {
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        back_btn.setOnClickListener {
            finish()
        }
    }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri -> uploadImage(uri)
    }
    var permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            isGranted ->
        if(isGranted){
            galleryLauncher.launch("image/*")
        }else{
            Toast.makeText(baseContext, "외부 저장소 읽기 권한을 승인해야 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
        }
    }
    fun uploadImage(uri: Uri){
        //1. 경로 + 사용자ID + 밀리초로 파일 주소 만들기
        var fullPath = makeFilePath("images", "temp", uri)
        //2. 스토리지에 저장할 경로 설정
        val imageRef = storage.getReference(fullPath)
        //3. 업로드 태스크 생성
        val uploadTask = imageRef.putFile(uri)

        //4. 업로드 실행 및 결과 확인
        uploadTask.addOnFailureListener{
            Log.d("스토리지", "실패=>${it.message}")
        }.addOnSuccessListener {taskSnapshot ->
            Log.d("스토리지", "성공 주소=>${fullPath}") //5. 경로를 DB에 저장하고 사용
        }
    }
    fun makeFilePath(path: String, userId: String, uri: Uri): String {
        val mimeType = contentResolver.getType(uri)?:"/none"
        val ext = mimeType.split("/")[1]
        val timeSuffix = System.currentTimeMillis()
        val filename = "${path}/${userId}_${timeSuffix}.${ext}"
        return filename
    }
}
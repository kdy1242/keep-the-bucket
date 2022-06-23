package com.example.keep_the_bucket

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.keep_the_bucket.databinding.ActivityDiaryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_diary.*
import java.text.SimpleDateFormat
import java.util.*


class DiaryActivity : AppCompatActivity() {
    val storage = Firebase.storage("gs://keepthebucket.appspot.com/")
    var auth : FirebaseAuth? = null
    var fbFirestore : FirebaseFirestore? = null
    var imageUri : String? = null

    private var firestore : FirebaseFirestore? = null
    private var uid : String? = null

    val binding by lazy { ActivityDiaryBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth
        fbFirestore = FirebaseFirestore.getInstance()

//        uid = FirebaseAuth.getInstance().currentUser?.uid
//        firestore = FirebaseFirestore.getInstance()

        Log.i("TAG", "onCreate: 다이어리 추가하기")

        val bingoNum = intent.getIntExtra("bingoNum",1)
        val bingoId = intent.getStringExtra("bingoID")

//        val data = fbFirestore?.collection("diary")?.whereEqualTo("num", bingoNum)?.get()?.addOnSuccessListener { result ->
//            if(!result.isEmpty) {
//                val num = result.first().getString("diary_cont")
//                Log.d("mytag", num.toString())
//                val intent = Intent(this,DiaryResultActivity::class.java)
//                intent.putExtra("bingoNum",num)
//                startActivity(intent)
//                finish()
//            }
//        }

        val nowTime = System.currentTimeMillis()
        val nowTimeDate = Date(nowTime)
        val timeDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("en", "EN"))

        binding.diaryImg.setOnClickListener {
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        binding.diarySave.setOnClickListener {
            var diaryModel = DiaryModel()
            diaryModel.num = bingoNum
            diaryModel.uid = auth?.currentUser?.uid
            diaryModel.title = diary_title_txt.text.toString()
            diaryModel.diary_cont = diary_contents.text.toString()
            diaryModel.timestamp = timeDateFormat.format(nowTimeDate)
            diaryModel.ImgUrl = imageUri

            // 빙고리스트 수정
            val diaryID = System.currentTimeMillis().toString() //자동아이디 생성
                fbFirestore?.collection("diary")?.document(diaryID)?.set(diaryModel)?.addOnSuccessListener {
                if (bingoId != null) {
                    fbFirestore?.collection("bingo_list")?.document(bingoId)?.update("diaryUID",diaryID)
                }
            }

            Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }
    val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            Log.i("TAG", "승인: "+uri)
            uploadImage(uri)
        }
    var permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                galleryLauncher.launch("image/*")
            } else {
                Toast.makeText(baseContext, "외부 저장소 읽기 권한을 승인해야 사용할 수 있습니다.", Toast.LENGTH_LONG)
                    .show()
            }
        }
    fun uploadImage(uri: Uri) {
        //1. 경로 + 사용자ID + 밀리초로 파일 주소 만들기
        var fullPath = makeFilePath("images", "temp", uri)
        //2. 스토리지에 저장할 경로 설정
        val imageRef = storage.getReference(fullPath)
        //3. 업로드 태스크 생성
        val uploadTask = imageRef.putFile(uri)

        Log.i("TAG", "uploadImage: 이미지"+uploadTask)
        //4. 업로드 실행 및 결과 확인
        uploadTask.addOnFailureListener{
            Log.d("스토리지", "실패=>${it.message}")
        }.addOnSuccessListener {taskSnapshot ->
            imageRef.downloadUrl.addOnSuccessListener {
                Log.d("스토리지", "성공 주소=>${it}") //5. 경로를 DB에 저장하고 사용
                imageUri = it.toString()

                Glide.with(this.applicationContext)
                    .load(imageUri)
                    .placeholder(R.drawable.ic_bingo_img)
                    .into(diary_img)
            }
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

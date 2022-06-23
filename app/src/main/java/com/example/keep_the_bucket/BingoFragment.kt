package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.keep_the_bucket.databinding.FragmentBingoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_bingo.*


class BingoFragment : Fragment() {
    private var _binding: FragmentBingoBinding? = null
    private val binding get() = _binding!!
    lateinit var fbFirestore : FirebaseFirestore
    var bingoListArray : ArrayList<String?> = ArrayList()
    var isDiaryArray : ArrayList<String?> = ArrayList()
    var bingoDocId : ArrayList<String> = ArrayList()
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBingoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgurls = ArrayList<String?>()
        val data = ArrayList<TextView>()
        data.add(bingo_txt1)
        data.add(bingo_txt2)
        data.add(bingo_txt3)
        data.add(bingo_txt4)
        data.add(bingo_txt5)
        data.add(bingo_txt6)
        data.add(bingo_txt7)
        data.add(bingo_txt8)
        data.add(bingo_txt9)
        data.add(bingo_txt10)
        data.add(bingo_txt11)
        data.add(bingo_txt12)
        data.add(bingo_txt13)
        data.add(bingo_txt14)
        data.add(bingo_txt15)
        data.add(bingo_txt16)

        val imgData = ArrayList<ImageView>()
        imgData.add(bingo_img1)
        imgData.add(bingo_img2)
        imgData.add(bingo_img3)
        imgData.add(bingo_img4)
        imgData.add(bingo_img5)
        imgData.add(bingo_img6)
        imgData.add(bingo_img7)
        imgData.add(bingo_img8)
        imgData.add(bingo_img9)
        imgData.add(bingo_img10)
        imgData.add(bingo_img11)
        imgData.add(bingo_img12)
        imgData.add(bingo_img13)
        imgData.add(bingo_img14)
        imgData.add(bingo_img15)
        imgData.add(bingo_img16)

        val frames = ArrayList<FrameLayout>()
        frames.add(bingo1)
        frames.add(bingo2)
        frames.add(bingo3)
        frames.add(bingo4)
        frames.add(bingo5)
        frames.add(bingo6)
        frames.add(bingo7)
        frames.add(bingo8)
        frames.add(bingo9)
        frames.add(bingo10)
        frames.add(bingo11)
        frames.add(bingo12)
        frames.add(bingo13)
        frames.add(bingo14)
        frames.add(bingo15)
        frames.add(bingo16)

//        bingo_txt1.setText("내용내용")

        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("bingo_list")
            .whereEqualTo("uid", auth.uid)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener { value, error ->
                Log.d("test", "addSnapshotListener")
                if (value != null ) {
                    bingoListArray.clear()
                    isDiaryArray.clear()
                    bingoDocId.clear()
//                    for (dc in value.documentChanges){
//                        Log.i("TAG", "onViewCreated: 삭제됨"+dc.document.data+" / "+dc.type)
//                        fbFirestore.collection("bingo_list").document(dc.document.id).delete()
//                        bingoListArray.clear()
//                    } //삭제 가능 코드
                    for(dc in value) {
                        var diary = ""
                        Log.i("TAG", "onViewCreated: diaryUID "+dc["diaryUID"])
                        if(dc["diaryUID"] !is String){
                            diary = ""
                        }else{
                            diary = dc["diaryUID"].toString()
                        }
                        Log.d("test", "DocumentChange.Type.ADDED")
                        bingoListArray.add(dc["bingoList"] as String?)
                        isDiaryArray.add(diary)
                        bingoDocId.add(dc.id)
                        bingoListArray[0]?.let { Log.d("test", it) }
                    }
                    // text 설정
                    for (i in 0..bingoListArray.size-1){
                        data[i].setText(bingoListArray[i]?:"")
                        // img 설정
                        if (!isDiaryArray[i].equals("") && isDiaryArray[i] != null){
                            Log.i("TAG", "onViewCreated: 다이얼 사진 가져오기"+isDiaryArray[i])
                            fbFirestore.collection("diary").document(isDiaryArray[i]!!).get()
                                .addOnSuccessListener {
                                    Log.i("TAG", "onViewCreated: 다이얼 사진 가져오기222"+it["imgUrl"])
                                    if (it["imgUrl"] as String? != null){
                                        Log.i("TAG", "onViewCreated: uiri사진"+it["imgUrl"])

                                        // 이미지 넣기
                                        context?.let { it1 ->
                                            Glide.with(it1)
                                                .load(it["imgUrl"])
                                                .fitCenter()
                                                .into(imgData[i])
                                        }
                                    }
                                }
                            

                        }

                        Log.d("bingotext"+i, ""+data[i].text)
                        Log.d("listarray"+i, ""+bingoListArray[i]?:"")
                        frames[i].setOnClickListener{
                            val bingoNum = i+1
                            Log.i("TAG", "uid 클릭번호 : "+it.id)
                            Log.i("TAG", "다이얼 클릭 : "+isDiaryArray[bingoNum-1]+" / "+bingoNum+bingoListArray[bingoNum-1])
                            if (isDiaryArray[bingoNum-1] != null && !isDiaryArray[bingoNum-1].equals("")){  // 일기가 있을 경우
                                val intent = Intent(this.context,DiaryResultActivity::class.java)
                                intent.putExtra("diaryID",isDiaryArray[bingoNum-1])
                                startActivity(intent)
                            }else{  // 없을 경우 추가하기
                                val intent = Intent(this.context,DiaryActivity::class.java)
                                intent.putExtra("bingoNum",bingoNum)
                                intent.putExtra("bingoID",bingoDocId[bingoNum-1])
                                startActivity(intent)
                            }
                        }
                    }
                }
            }

//        bingo1.setOnClickListener(bClickLister)
//        bingo2.setOnClickListener(bClickLister)
//        bingo3.setOnClickListener(bClickLister)
//        bingo4.setOnClickListener(bClickLister)
//        bingo5.setOnClickListener(bClickLister)
//        bingo6.setOnClickListener(bClickLister)
//        bingo7.setOnClickListener(bClickLister)
//        bingo8.setOnClickListener(bClickLister)
//        bingo9.setOnClickListener(bClickLister)
//        bingo10.setOnClickListener(bClickLister)
//        bingo11.setOnClickListener(bClickLister)
//        bingo12.setOnClickListener(bClickLister)
//        bingo13.setOnClickListener(bClickLister)
//        bingo14.setOnClickListener(bClickLister)
//        bingo15.setOnClickListener(bClickLister)
//        bingo16.setOnClickListener(bClickLister)
    }

    val bClickLister : View.OnClickListener = View.OnClickListener{
        var bingoNum = 1
        Log.i("TAG", "uid 클릭번호 : "+it.id)
        when(it.id) {
            R.id.bingo1 -> {
                bingoNum = 1
            }
            R.id.bingo2 -> {
                bingoNum = 2
            }
            R.id.bingo3 -> {
                bingoNum = 3
            }
            R.id.bingo4 -> {
                bingoNum = 4
            }
            R.id.bingo5 -> {
                bingoNum = 5
            }
            R.id.bingo6 -> {
                bingoNum = 6
            }
            R.id.bingo7 -> {
                bingoNum = 7
            }
            R.id.bingo8 -> {
                bingoNum = 8
            }
            R.id.bingo9 -> {
                bingoNum = 9
            }
            R.id.bingo10 -> {
                bingoNum = 10
            }
            R.id.bingo11 -> {
                bingoNum = 11
            }
            R.id.bingo12 -> {
                bingoNum = 12
            }
            R.id.bingo13 -> {
                bingoNum = 13
            }
            R.id.bingo14 -> {
                bingoNum = 14
            }
            R.id.bingo15 -> {
                bingoNum = 15
            }
            R.id.bingo16 -> {
                bingoNum = 16
            }
        }
        Log.i("TAG", "다이얼 클릭 : "+isDiaryArray[bingoNum-1]+" / "+bingoNum+bingoListArray[bingoNum-1])
        if (isDiaryArray[bingoNum-1] != null && !isDiaryArray[bingoNum-1].equals("")){  // 일기가 있을 경우
            val intent = Intent(this.context,DiaryResultActivity::class.java)
            intent.putExtra("diaryID",isDiaryArray[bingoNum-1])
            startActivity(intent)
        }else{  // 없을 경우 추가하기
            val intent = Intent(this.context,DiaryActivity::class.java)
            intent.putExtra("bingoNum",bingoNum)
            intent.putExtra("bingoID",bingoDocId[bingoNum-1])
            startActivity(intent)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
    }

}
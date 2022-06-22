package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
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

//        bingo_txt1.setText("내용내용")

        fbFirestore = FirebaseFirestore.getInstance()
        fbFirestore.collection("bingo_list")
            .whereEqualTo("uid", auth.uid)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener { value, error ->
                Log.d("test", "addSnapshotListener")
                if (value != null) {
                    bingoListArray.clear()
                    for(dc in value) {
                        Log.d("test", "DocumentChange.Type.ADDED")
                        bingoListArray.add(dc["bingoList"] as String?)
                        bingoListArray[0]?.let { Log.d("test", it) }
                    }
                    // text 설정
                    for (i in 0..bingoListArray.size-1){
                        data[i].setText(bingoListArray[i]?:"")

                        Log.d("bingotext"+i, ""+data[i].text)
                        Log.d("listarray"+i, ""+bingoListArray[i]?:"")
                        data[i].setOnClickListener(bClickLister)
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
        when(it.id){
            R.id.bingo1 -> {
                bingoNum =1
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

        val intent = Intent(this.context,DiaryActivity::class.java)
        intent.putExtra("bingoNum",bingoNum)
        startActivity(intent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
    }

}
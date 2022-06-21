package com.example.keep_the_bucket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.keep_the_bucket.databinding.FragmentBingoBinding
import kotlinx.android.synthetic.main.fragment_bingo.*


class BingoFragment : Fragment() {
    private var _binding: FragmentBingoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBingoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bingo1.setOnClickListener(bClickLister)
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
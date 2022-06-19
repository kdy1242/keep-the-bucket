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
        val view = binding.root
        return view

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_bingo, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ImgPlus1.setOnClickListener {
            activity?.let{
                val intent = Intent(context, DiaryActivity::class.java)
                startActivity(intent)
            }
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
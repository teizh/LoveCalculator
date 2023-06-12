package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.data.remote.LoveModel
import com.example.lovecalculator.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showResult()
        tryAgain()
    }

    private fun tryAgain() {
        binding.btnTryAgain.setOnClickListener {
            val bundle = Bundle().apply {
                putBoolean("clearEditText", true)
            }
            findNavController().navigate(R.id.firstFragment)
        }
    }
    fun showResult() {
        with(binding) {
            val result = arguments?.getSerializable("result") as LoveModel
            tvDescription.text = result.result
            tvPercentage.text = result.percentage
        }
    }

}
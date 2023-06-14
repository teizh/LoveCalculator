package com.example.lovecalculator.ui.onBoard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator.ui.onBoard.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    lateinit var binding: FragmentOnBoardingBinding

    @Inject
    lateinit var pref: Pref


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OnBoardingAdapter(this::onClick)
        with(binding) {
            viewPager.adapter = adapter
        }

    }

    private fun onClick(onBoard: OnBoardModel) {
        findNavController().navigateUp()
        pref.saveUserSeen()
    }
}


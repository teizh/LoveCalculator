package com.example.lovecalculator.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        clickHistory()
    }

    private fun clickHistory() {
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    /*    private fun showResult(
            percentage: String,
            description: String,
            firstName: String,
            secondName: String
        ) {
            binding.tvPercentage.text = "$firstName and $secondName have $percentage% chance!"
            binding.tvDescription.text = description

            binding.tvPercentage.visibility = View.VISIBLE
            binding.tvDescription.visibility = View.VISIBLE

            Handler().postDelayed({
                binding.firstEd.visibility = View.VISIBLE
                binding.secondEd.visibility = View.VISIBLE
                binding.tvPercentage.visibility = View.INVISIBLE
                binding.tvDescription.visibility = View.INVISIBLE
            }, 10000)
        }*/
    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                //utils.showToast(this@MainActivity)
                viewModel.getLiveLove(
                    firstEd.text.toString(), secondEd.text.toString()
                ).observe(viewLifecycleOwner) {
                    Log.e("ololo", "initClickers: $it")/*   showResult(
                           loveModel.percentage,
                           loveModel.result,
                           loveModel.firstName,
                           loveModel.secondName
                       )*/
                    findNavController().navigate(R.id.secondFragment, bundleOf("result" to it))
                    App.appDatabase.getDao().insert(it)
                }

            }
        }
    }


}
package com.example.lovecalculator

import android.annotation.SuppressLint
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.example.lovecalculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        binding.tvPercentage.visibility = View.INVISIBLE
        binding.tvDescription.visibility = View.INVISIBLE
    }
    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                RetrofitService().api.getPercentage(
                    firstEd.text.toString(),
                    secondEd.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", " onResponse: ${response.body()}")
                        response.body()?.let { it1 -> showResult(it1.percentage, it1.result, it1.firstName, it1.secondName) }
                    }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", " onFailure: ${t.message}")
                    }
                })
            }
        }
    }

    private fun showResult(percentage: String, description: String, firstName: String, secondName: String) {
        binding.tvPercentage.text = "$firstName and $secondName have $percentage% chance!"
        binding.tvDescription.text = description
        binding.firstEd.visibility = View.INVISIBLE
        binding.secondEd.visibility = View.INVISIBLE
        binding.tvPercentage.visibility = View.VISIBLE
        binding.tvDescription.visibility = View.VISIBLE

        Handler().postDelayed({
            binding.firstEd.visibility = View.VISIBLE
            binding.secondEd.visibility = View.VISIBLE
            binding.tvPercentage.visibility = View.INVISIBLE
            binding.tvDescription.visibility = View.INVISIBLE
        }, 10000)
    }
}

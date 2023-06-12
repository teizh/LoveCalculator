package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.Utils
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
   // val viewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var pref: Pref
    //  @Inject
    //  lateinit var utils: Utils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        if (!pref.isUserSeen()) {
            navController.navigate(R.id.onBoardingFragment)
        }
  /*      initClickers()
        binding.tvPercentage.visibility = View.INVISIBLE
        binding.tvDescription.visibility = View.INVISIBLE*/
    }


}

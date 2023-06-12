package com.example.lovecalculator

import android.content.Context
import android.widget.Toast
import dagger.Provides
import javax.inject.Inject


class Utils {

    fun showToast (context: Context){
        Toast.makeText(context," Hello ", Toast.LENGTH_LONG).show()
    }
}
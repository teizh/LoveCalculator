package com.example.lovecalculator

import android.content.Context
import android.widget.Toast

class Utils {
    fun showToast (context: Context){
        Toast.makeText(context, "hello", Toast.LENGTH_LONG).show()
    }
}
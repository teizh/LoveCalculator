package com.example.lovecalculator.data.local

import android.content.Context
import android.content.SharedPreferences

class Pref(requireContext: Context) {
    private val pref: SharedPreferences = requireContext.getSharedPreferences(
        PREF_KEY,
        Context.MODE_PRIVATE
    )

    fun isUserSeen(): Boolean {
        return pref.getBoolean(USER_SEEN_KEY, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(USER_SEEN_KEY, true).apply()
    }

    companion object {
        const val PREF_KEY = "Key"
        const val USER_SEEN_KEY = "Key2"
    }
}
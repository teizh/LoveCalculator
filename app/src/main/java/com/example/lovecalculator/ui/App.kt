package com.example.lovecalculator.ui

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.data.local.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    companion object {
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_file")
                .allowMainThreadQueries().build()
    }
}
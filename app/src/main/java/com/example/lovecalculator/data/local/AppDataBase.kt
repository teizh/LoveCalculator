package com.example.lovecalculator.data.local


import androidx.room.RoomDatabase
import com.example.lovecalculator.data.remote.LoveModel


@androidx.room.Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}
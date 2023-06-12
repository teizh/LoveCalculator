package com.example.lovecalculator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.example.lovecalculator.data.remote.LoveModel as LoveModel1
@Dao
interface  LoveDao {
    @Insert
    fun insert(loveModel: LoveModel1)

    @Query("Select * FROM love_table")
    fun getAll(): List<LoveModel1>

    @Query("Select * FROM love_table ORDER BY firstName ASC")
    fun getAllSort(): List<LoveModel1>
}

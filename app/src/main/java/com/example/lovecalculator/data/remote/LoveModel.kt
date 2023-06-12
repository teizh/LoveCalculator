package com.example.lovecalculator.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "love_table")
data class LoveModel (
    @SerializedName("fname")
    val firstName:String,
    @SerializedName("sname")
    val secondName:String,
    val percentage:String,
    val result:String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
        ):java.io.Serializable
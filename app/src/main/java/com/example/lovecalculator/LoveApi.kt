package com.example.lovecalculator
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") first: String,
        @Query("sname") second: String,
        @Header("X-RapidAPI-Key") key: String = "73e5be8e25msh8153a46826d42d4p178787jsn23c30c95cb65",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}
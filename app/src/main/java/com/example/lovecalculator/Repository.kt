package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.data.remote.LoveApi
import com.example.lovecalculator.data.remote.LoveModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {
    fun getLoveMutableLiveData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName )
            .enqueue(object:  retrofit2.Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }


            })

        return liveData
    }
}
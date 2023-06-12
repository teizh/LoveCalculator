package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.data.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel(){
     fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}
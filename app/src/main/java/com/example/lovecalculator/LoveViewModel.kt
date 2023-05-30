package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import kotlinx.coroutines.internal.LockFreeLinkedListNode

class LoveViewModel : ViewModel(){
    val repository = Repository()
    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}
package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.internal.LockFreeLinkedListNode
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel(){
     fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}
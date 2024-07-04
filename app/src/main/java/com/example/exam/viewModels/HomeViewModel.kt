package com.example.exam.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam.model.ProcessModel
import com.example.exam.repositories.ProcessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val processRepository: ProcessRepository
) : ViewModel() {

    private val _elements = MutableLiveData<List<ProcessModel>>()
    val elements: LiveData<List<ProcessModel>> get() = _elements

    fun loadData() {
        viewModelScope.launch {
            val response = processRepository.getRemoteProcess()
            _elements.postValue(response)
        }
    }
}
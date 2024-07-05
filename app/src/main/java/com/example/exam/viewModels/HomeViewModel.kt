package com.example.exam.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam.model.MetalModel
import com.example.exam.model.ProcessModel
import com.example.exam.repositories.ProcessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val processRepository: ProcessRepository
) : ViewModel() {

    private val _processes = MutableLiveData<List<ProcessModel>>()
    val processes: LiveData<List<ProcessModel>> get() = _processes

    private val _metals = MutableLiveData<List<MetalModel>>()
    val metals: LiveData<List<MetalModel>> get() = _metals

    fun getProcess() {
        viewModelScope.launch {
            // TODO: Endpoint down, instead fake data
//            val response = processRepository.getRemoteProcess()
//            _elements.postValue(response)
            _processes.postValue(
                listOf(
                    ProcessModel("1", "a", "1a"),
                    ProcessModel("2", "b", "2b"),
                    ProcessModel("3", "c", "3c"),
                )
            )
        }
    }

    fun getMetals() {
        viewModelScope.launch {
            val metals = processRepository.getLocalMetals()
            _metals.postValue(metals)
        }
    }
}
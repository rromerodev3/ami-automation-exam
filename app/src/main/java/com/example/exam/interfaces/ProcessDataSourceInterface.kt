package com.example.exam.interfaces

import com.example.exam.model.MetalModel
import com.example.exam.model.ProcessModel

interface ProcessDataSourceInterface {
    suspend fun getRemoteProcess(): List<ProcessModel>
    suspend fun getLocalMetals(): List<MetalModel>
}
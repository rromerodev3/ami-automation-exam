package com.example.exam.interfaces

import com.example.exam.model.ProcessModel

interface ProcessDataSourceInterface {
    suspend fun getRemoteProcess(): List<ProcessModel>
}
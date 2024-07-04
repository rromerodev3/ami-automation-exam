package com.example.exam.api

import com.example.exam.model.ProcessModel
import retrofit2.http.GET

interface ProcessService {
    @GET("process-api")
    suspend fun getProcesses(): List<ProcessModel>
}
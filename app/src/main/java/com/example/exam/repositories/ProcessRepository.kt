package com.example.exam.repositories

import com.example.exam.api.ProcessService
import com.example.exam.interfaces.ProcessDataSourceInterface
import com.example.exam.model.ProcessModel
import javax.inject.Inject

class ProcessRepository @Inject constructor(
    private val remoteDataSource: ProcessService
): ProcessDataSourceInterface {
    override suspend fun getRemoteProcess(): List<ProcessModel> {
        return remoteDataSource.getProcesses()
    }
}
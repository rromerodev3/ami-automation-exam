package com.example.exam.db

import androidx.room.Dao
import androidx.room.Query
import com.example.exam.model.MetalModel

@Dao
interface MetalDao {
    @Query("SELECT * FROM metals")
     suspend fun getAll(): List<MetalModel>
}
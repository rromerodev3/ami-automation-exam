package com.example.exam.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exam.model.MetalModel

@Database(entities = [MetalModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun metalDao(): MetalDao
}
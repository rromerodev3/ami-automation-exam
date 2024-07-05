package com.example.exam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Metals")
data class MetalModel(
    @ColumnInfo(name = "ExternalUse") val externalUse: Int?,
    @PrimaryKey @ColumnInfo(name = "Id") val id: Int?,
    @ColumnInfo(name = "Description") val description: String?,
    @ColumnInfo(name = "Name") val name: String?,
)
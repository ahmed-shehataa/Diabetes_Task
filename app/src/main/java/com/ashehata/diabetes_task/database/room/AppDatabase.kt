package com.ashehata.diabetes_task.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.ashehata.diabetes_task.features.diabetes.data.local.dao.DiabetesDao

@Database(entities = [DrugDataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun diabetesDao(): DiabetesDao
}
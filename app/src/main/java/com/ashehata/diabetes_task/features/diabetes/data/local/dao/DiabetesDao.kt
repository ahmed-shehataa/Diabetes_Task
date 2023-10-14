package com.ashehata.orange_task.modules.news.data.local.dao

import androidx.room.*
import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel

@Dao
interface DiabetesDao {

    @Query("SELECT * FROM drugs")
    fun getDrugs(): List<DrugDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drugs: List<DrugDataModel>)

    @Query("DELETE FROM drugs")
    suspend fun deleteAll()

}
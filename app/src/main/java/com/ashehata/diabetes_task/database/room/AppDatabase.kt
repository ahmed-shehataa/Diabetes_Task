package com.ashehata.diabetes_task.database.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Database(entities = [NewsDataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}

@Entity
data class NewsDataModel(
    @PrimaryKey
    var sad: String
)

@Dao
interface NewsDao {

}

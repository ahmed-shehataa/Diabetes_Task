package com.ashehata.diabetes_task.features.diabetes.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Keep
@Entity(tableName = "drugs")
data class DrugDataModel(
    @Json(name = "name")
    @PrimaryKey
    val name: String,
    @Json(name = "dose")
    val dose: String?,
    @Json(name = "strength")
    val strength: String?
)
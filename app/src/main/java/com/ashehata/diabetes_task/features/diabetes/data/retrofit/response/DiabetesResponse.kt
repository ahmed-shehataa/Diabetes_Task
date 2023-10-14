package com.ashehata.diabetes_task.features.diabetes.data.retrofit.response

import androidx.annotation.Keep
import com.ashehata.diabetes_task.features.diabetes.data.model.DrugDataModel
import com.squareup.moshi.Json

@Keep
data class DiabetesResponse(
    @Json(name = "problems")
    val problems: List<Problem>?
)

@Keep
data class Problem(
    @Json(name = "Asthma")
    val asthma: List<Asthma>?,
    @Json(name = "Diabetes")
    val diabetes: List<Diabete>?
)

@Keep
class Asthma

@Keep
data class Diabete(
    @Json(name = "labs")
    val labs: List<Lab>?,
    @Json(name = "medications")
    val medications: List<Medication>?
)

@Keep
data class Lab(
    @Json(name = "missing_field")
    val missingField: String?
)

@Keep
data class Medication(
    @Json(name = "medicationsClasses")
    val medicationsClasses: List<MedicationsClasse>?
)

@Keep
data class MedicationsClasse(
    @Json(name = "className")
    val className: List<ClassName>?,
    @Json(name = "className2")
    val className2: List<ClassName>?
)

@Keep
data class ClassName(
    @Json(name = "associatedDrug")
    val drugDataModel: List<DrugDataModel>?,
    @Json(name = "associatedDrug#2")
    val drugDataModel2: List<DrugDataModel>?
)
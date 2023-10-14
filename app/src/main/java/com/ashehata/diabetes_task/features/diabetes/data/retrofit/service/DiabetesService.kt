package com.ashehata.diabetes_task.features.diabetes.data.retrofit.service

import com.ashehata.diabetes_task.features.diabetes.data.retrofit.response.DiabetesResponse
import retrofit2.http.GET


interface DiabetesService {

    @GET("")
    suspend fun getDiabetes(): DiabetesResponse
}
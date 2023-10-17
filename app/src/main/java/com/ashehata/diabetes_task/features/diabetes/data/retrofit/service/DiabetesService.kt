package com.ashehata.diabetes_task.features.diabetes.data.retrofit.service

import com.ashehata.diabetes_task.features.diabetes.data.retrofit.response.DiabetesResponse
import retrofit2.http.GET


interface DiabetesService {

    @GET("efb7491b-323a-4ee2-aaee-f7fa1284dadb")
    suspend fun getDiabetes(): DiabetesResponse
}
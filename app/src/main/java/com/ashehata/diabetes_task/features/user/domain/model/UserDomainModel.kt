package com.ashehata.diabetes_task.features.user.domain.model

import androidx.annotation.Keep
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

@Keep
data class UserDomainModel(val email: String) {

    companion object {
        fun create(json: String): UserDomainModel {
            return try {
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val adapter = moshi.adapter(UserDomainModel::class.java)
                adapter.fromJson(json)!!
            } catch (e: Exception) {
                throw IOException()
            }
        }
    }

    override fun toString(): String {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter(UserDomainModel::class.java)
        return adapter.toJson(this)
    }

}

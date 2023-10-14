package com.ashehata.diabetes_task.features.user.data.mapper

import com.ashehata.diabetes_task.features.user.data.model.UserDataModel
import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel

fun UserDataModel.toDomainModel(): UserDomainModel = UserDomainModel(email)


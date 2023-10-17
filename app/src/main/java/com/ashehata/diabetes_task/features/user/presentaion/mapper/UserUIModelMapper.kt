package com.ashehata.diabetes_task.features.user.presentaion.mapper

import com.ashehata.diabetes_task.features.user.domain.model.UserDomainModel
import com.ashehata.diabetes_task.features.user.presentaion.model.UserUIModel


fun UserDomainModel.toUIModel() = UserUIModel(
    email
)
package com.ashehata.diabetes_task.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

interface BaseIntent

interface BaseAction

abstract class BaseViewState {
    val isRefreshing: MutableState<Boolean> = mutableStateOf(false)
    val isNetworkError: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: MutableState<Boolean> = mutableStateOf(false)
}
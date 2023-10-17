package com.ashehata.diabetes_task.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<Intent : BaseIntent, ViewState : BaseViewState, Action : BaseAction>
    : ViewModel() {

    private val initialState: Action? by lazy { createInitialState() }

    private val initialViewState: ViewState? by lazy { createInitialViewState() }

    val viewStates: ViewState? by lazy {
        createInitialViewState()
    }

    private val _state = MutableStateFlow(initialState)
    val state get() = _state.asStateFlow().filterNotNull()

    private val _event = MutableSharedFlow<Intent>()
    private val event get() = _event.asSharedFlow()

    private val defaultExceptionHandler = exceptionHandler {
        handleCustomNetworkError()
        Log.i("defaultExceptionHandler", it.localizedMessage)
    }

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvents(it)
            }
        }
    }

    fun setEvent(event: Intent) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    /**
     * Set new Ui Action
     */
    fun setState(builder: () -> Action?) {
        viewModelScope.launch {
            _state.emit(builder())
        }
    }

    open fun createInitialState(): Action? {
        return null
    }

    open fun createInitialViewState(): ViewState? {
        return null
    }

    open fun resetViewStates() {}

    abstract fun handleEvents(event: Intent)
    fun consumeState() {
        setState { null }
    }

    protected fun launchCoroutine(
        customContext: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(defaultExceptionHandler + customContext) {
            block()
        }
    }

    private fun handleCustomNetworkError() {
        viewStates?.isNetworkError?.value = true
        viewStates?.isLoading?.value = false
        viewStates?.isRefreshing?.value = false
    }

    protected fun exceptionHandler(onCatch: ((Throwable) -> Unit)): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, exception ->
            onCatch(exception)
        }
    }

    fun setLoading() {
        viewStates?.isLoading?.value = true
        viewStates?.isNetworkError?.value = false
    }

    fun setDoneLoading() {
        viewStates?.isLoading?.value = false
        viewStates?.isRefreshing?.value = false
    }

}

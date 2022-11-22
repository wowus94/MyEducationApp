package com.example.myeducationapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myeducationapp.model.data.AppState
import kotlinx.coroutines.*

abstract class BaseViewModel<T : AppState>(

    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable -> handlerError(throwable) }
    )

    abstract fun handlerError(error: Throwable)

    abstract fun getData(word: String, isOnline: Boolean)

    override fun onCleared() {
        cancelJob()
    }

    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }
}
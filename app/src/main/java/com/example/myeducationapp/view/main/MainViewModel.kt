package com.example.myeducationapp.view.main

import androidx.lifecycle.LiveData
import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.utils.parseSearchResults
import com.example.myeducationapp.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(parseSearchResults(interactor.getData(word, isOnline)))
        }

    override fun handlerError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Success(null))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }

}
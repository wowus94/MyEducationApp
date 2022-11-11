package com.example.myeducationapp.main

import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.presenter.Interactor
import com.example.myeducationapp.repository.Repository

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): io.reactivex.Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        }else{
            localRepository.getData(word).map { AppState.Success(it)}

        }
    }
}

package com.example.myeducationapp.view.main

import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.model.repository.Repository
import com.example.myeducationapp.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}

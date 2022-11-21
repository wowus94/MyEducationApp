package com.example.myeducationapp.view.main

import com.example.myeducationapp.di.NAME_LOCAL
import com.example.myeducationapp.di.NAME_REMOTE
import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.model.repository.Repository
import com.example.myeducationapp.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}

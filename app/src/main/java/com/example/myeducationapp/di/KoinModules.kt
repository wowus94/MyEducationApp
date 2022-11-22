package com.example.myeducationapp.di

import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.model.data.datasource.RetrofitImplementation
import com.example.myeducationapp.model.data.datasource.RoomDataBaseImplementation
import com.example.myeducationapp.model.repository.Repository
import com.example.myeducationapp.model.repository.RepositoryImplementation
import com.example.myeducationapp.view.main.MainInteractor
import com.example.myeducationapp.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
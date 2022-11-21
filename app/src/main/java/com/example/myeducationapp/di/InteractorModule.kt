package com.example.myeducationapp.di

import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.model.repository.Repository
import com.example.myeducationapp.view.main.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
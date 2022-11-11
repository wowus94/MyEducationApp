package com.example.myeducationapp.repository

import com.example.myeducationapp.datasource.DataSource
import com.example.myeducationapp.model.data.DataModel
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}

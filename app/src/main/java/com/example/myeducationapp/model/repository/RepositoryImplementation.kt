package com.example.myeducationapp.model.repository

import com.example.myeducationapp.model.data.DataModel
import com.example.myeducationapp.model.data.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}

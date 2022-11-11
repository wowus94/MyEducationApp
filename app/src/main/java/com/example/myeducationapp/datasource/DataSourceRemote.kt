package com.example.myeducationapp.datasource

import com.example.myeducationapp.model.data.DataModel
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvider.getData(word)

}

package com.example.myeducationapp.model.data.datasource

import com.example.myeducationapp.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")

    }
}

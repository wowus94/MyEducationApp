package com.example.myeducationapp.model.data.datasource

import com.example.myeducationapp.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented")
    }
}


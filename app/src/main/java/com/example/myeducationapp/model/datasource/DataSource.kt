package com.example.myeducationapp.model.data.datasource


interface DataSource<T> {

    suspend fun getData(word: String): T
}

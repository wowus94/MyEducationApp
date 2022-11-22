package com.example.myeducationapp.model.repository


interface Repository<T> {

    suspend fun getData(word: String): T
}
package com.example.myeducationapp.repository

import java.util.Observable

interface Repository<T> {

    fun getData(word: String): Observable
}
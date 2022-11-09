package com.example.myeducationapp.presenter

import java.util.*

interface Interactor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable
}
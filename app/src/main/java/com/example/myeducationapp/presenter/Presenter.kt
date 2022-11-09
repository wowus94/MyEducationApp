package com.example.myeducationapp.presenter

import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
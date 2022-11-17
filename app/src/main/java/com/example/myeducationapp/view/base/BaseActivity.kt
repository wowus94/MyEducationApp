package com.example.myeducationapp.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.myeducationapp.model.data.AppState
import com.example.myeducationapp.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)

}
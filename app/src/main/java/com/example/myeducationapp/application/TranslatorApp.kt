package com.example.myeducationapp.application

import android.app.Application
import com.example.myeducationapp.di.application
import com.example.myeducationapp.di.mainScreen
import org.koin.core.context.startKoin


class TranslatorApp : Application(){


    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(listOf(application, mainScreen))
        }
    }
}
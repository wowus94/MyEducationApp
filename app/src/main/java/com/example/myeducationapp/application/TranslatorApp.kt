package com.example.myeducationapp.application

import android.app.Application
import com.example.myeducationapp.di.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject

class TranslatorApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
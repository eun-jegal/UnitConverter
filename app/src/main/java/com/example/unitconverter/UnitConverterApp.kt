package com.example.unitconverter

import android.app.Application
import com.example.unitconverter.di.AppComponent
import com.example.unitconverter.di.AppModule
import com.example.unitconverter.di.DaggerAppComponent

class UnitConverterApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }
}
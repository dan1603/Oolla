package com.kalashnyk.denys.oollatest.di.component

import com.google.gson.Gson
import com.kalashnyk.denys.oollatest.di.module.AppModule
import com.kalashnyk.denys.oollatest.di.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson: Gson
}
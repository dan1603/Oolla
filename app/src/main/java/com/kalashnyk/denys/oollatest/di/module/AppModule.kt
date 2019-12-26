package com.kalashnyk.denys.oollatest.di.module

import android.app.Application
import com.google.gson.Gson
import com.kalashnyk.denys.oollatest.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app : Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @AppScope
    fun provideGson(): Gson {
        return Gson()
    }
}
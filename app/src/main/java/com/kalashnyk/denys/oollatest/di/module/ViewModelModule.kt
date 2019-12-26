package com.kalashnyk.denys.oollatest.di.module

import android.app.Application
import com.kalashnyk.denys.oollatest.App
import com.kalashnyk.denys.oollatest.di.scope.ViewModelScope
import com.kalashnyk.denys.oollatest.domain.RepositoriesViewModel
import com.kalashnyk.denys.oollatest.usecases.RepositoriesUseCases
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesFeedViewModel(repositoriesUseCases: RepositoriesUseCases): RepositoriesViewModel {
        return RepositoriesViewModel(repositoriesUseCases)
    }
}
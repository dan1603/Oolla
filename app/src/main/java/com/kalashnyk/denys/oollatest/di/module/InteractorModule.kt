package com.kalashnyk.denys.oollatest.di.module

import com.kalashnyk.denys.oollatest.di.scope.InteractorScope
import com.kalashnyk.denys.oollatest.usecases.*
import com.kalashnyk.denys.oollatest.usecases.repository.RepositoriesRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @InteractorScope
    @Provides
    internal fun providesRepositoriesUseCases(repository: RepositoriesRepository): RepositoriesUseCases {
        return RepositoriesUseCasesImpl(repository)
    }
}
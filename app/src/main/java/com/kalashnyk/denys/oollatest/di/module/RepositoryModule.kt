package com.kalashnyk.denys.oollatest.di.module

import com.kalashnyk.denys.oollatest.di.scope.RepositoryScope
import com.kalashnyk.denys.oollatest.usecases.repository.*
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.RepositoryDataSource
import com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source.RepositoryRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @RepositoryScope
    @Provides
    internal fun providesFeedRepository(repositoryRemoteDataSource: RepositoryRemoteDataSource, repositoryDataSource: RepositoryDataSource): RepositoriesRepository {
        return RepositoriesRepositoryImpl(repositoryRemoteDataSource, repositoryDataSource)
    }
}
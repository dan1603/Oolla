package com.kalashnyk.denys.oollatest.di.component

import com.kalashnyk.denys.oollatest.di.module.ApiModule
import com.kalashnyk.denys.oollatest.di.scope.ApiScope
import com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source.RepositoryRemoteDataSource
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class], dependencies = [AppComponent::class])
interface ApiComponent {
    val repositoryRemoteDataSource: RepositoryRemoteDataSource
}

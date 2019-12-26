package com.kalashnyk.denys.oollatest.di.component

import com.kalashnyk.denys.oollatest.di.module.DatabaseModule
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.RepositoryDataSource
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val repositoryDataSource: RepositoryDataSource
}

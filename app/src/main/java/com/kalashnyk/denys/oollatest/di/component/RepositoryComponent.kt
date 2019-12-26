package com.kalashnyk.denys.oollatest.di.component

import com.kalashnyk.denys.oollatest.di.module.RepositoryModule
import com.kalashnyk.denys.oollatest.di.scope.RepositoryScope
import com.kalashnyk.denys.oollatest.usecases.repository.RepositoriesRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repositoriesRepository: RepositoriesRepository
}
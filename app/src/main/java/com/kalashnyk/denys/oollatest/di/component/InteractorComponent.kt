package com.kalashnyk.denys.oollatest.di.component

import com.kalashnyk.denys.oollatest.di.module.InteractorModule
import com.kalashnyk.denys.oollatest.di.scope.InteractorScope
import com.kalashnyk.denys.oollatest.usecases.RepositoriesUseCases
import dagger.Component

@InteractorScope
@Component(modules = [InteractorModule::class], dependencies = [RepositoryComponent::class])
interface InteractorComponent {
    val repositoriesUseCases : RepositoriesUseCases
}
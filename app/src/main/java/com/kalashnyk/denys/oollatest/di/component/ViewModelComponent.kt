package com.kalashnyk.denys.oollatest.di.component

import com.kalashnyk.denys.oollatest.di.module.ViewModelModule
import com.kalashnyk.denys.oollatest.di.scope.ViewModelScope
import com.kalashnyk.denys.oollatest.presentation.activities.main.MainActivity
import com.kalashnyk.denys.oollatest.presentation.activities.splash.SplashActivity
import com.kalashnyk.denys.oollatest.presentation.fragments.repositories.RepositoriesFragment
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [InteractorComponent::class])
interface ViewModelComponent {
    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)
    fun inject(fragment: RepositoriesFragment)
}
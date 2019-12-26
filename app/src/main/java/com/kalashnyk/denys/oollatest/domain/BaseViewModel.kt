package com.kalashnyk.denys.oollatest.domain

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.kalashnyk.denys.oollatest.presentation.base.LoadingState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable=CompositeDisposable()
    val macroLoadingState = MediatorLiveData<LoadingState>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
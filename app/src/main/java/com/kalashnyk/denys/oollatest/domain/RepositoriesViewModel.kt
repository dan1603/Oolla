package com.kalashnyk.denys.oollatest.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.presentation.base.ItemsLoadListener
import com.kalashnyk.denys.oollatest.usecases.RepositoriesUseCases
import com.kalashnyk.denys.oollatest.utils.ConverterFactory
import java.util.*

class RepositoriesViewModel(private val repositoriesUseCases: RepositoriesUseCases) : BasePagingViewModel() {

    init {
        initPagedConfig()
    }

    fun initLiveData(listener: ItemsLoadListener<PagedList<RepositoryDisplayModel>>) {
        itemLoadedListener = listener
        initPagedListLiveData(repositoriesUseCases.getCardsFactory(ConverterFactory()))
    }

    fun getPagedList(): LiveData<PagedList<RepositoryDisplayModel>> = listCards

    override fun fetchData(username: String) {
        compositeDisposable.add(repositoriesUseCases.fetchRepositories(username)
            .subscribe({ setRefreshing(false) }, { throwable ->
                if (throwable is NoSuchElementException) {
                    itemLoadedListener.onItemsLoaded(null)
                } else {
                    throwable.message?.let { itemLoadedListener.onLoadError(it) }
                }
                setRefreshing(false)
            })
        )
    }

    override fun rangeData(username: String, page: Int) {
        setLoading(true)
        compositeDisposable.add(repositoriesUseCases.fetchRepositoriesNext(username, page)
            .subscribe({ setLoading(false) },
                { setLoading(false) }
            )
        )
    }

    override fun clearCachedItems() {
        repositoriesUseCases.deleteCachedFeed()
    }
}

package com.kalashnyk.denys.oollatest.usecases.repository

import androidx.paging.DataSource
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.RepositoryDataSource
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity
import com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source.RepositoryRemoteDataSource
import com.kalashnyk.denys.oollatest.utils.ConverterFactory
import io.reactivex.Completable
import io.reactivex.Single

interface RepositoriesRepository {

    fun fetchRepositories(username: String): Completable

    fun fetchRepositoriesNext(username: String, lastItemId: Int): Completable

    fun deleteCachedRepositories(): Completable

    fun getFactory(
        modelConverter: ConverterFactory
    ): DataSource.Factory<Int, RepositoryDisplayModel>
}

class RepositoriesRepositoryImpl(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource,
    private val repositoryDataSource: RepositoryDataSource
) : RepositoriesRepository {

    override fun fetchRepositories(username: String): Completable {
        return repositoryRemoteDataSource
            .fetchRepositories(username)
            .doOnSuccess {
                it.body()?.let { list -> saveItems(list, username,false) }
            }
            .doOnError {
                it.printStackTrace()
            }
            .flatMapCompletable {
                Completable.fromAction { }
            }
    }

    override fun fetchRepositoriesNext(username: String, lastPage: Int): Completable {
        return repositoryRemoteDataSource
            .fetchRepositoriesNext(username, lastPage)
            .flatMap {
                it.body()?.let { list ->
                    list.forEach { it.convertItemForDataSource(item = it, isCached = true) }
                    return@let Single.just(list)
                }
            }
            .flatMapCompletable {
                Completable.fromAction { saveItems(it, username, true) }
            }
    }

    override fun deleteCachedRepositories(): Completable=
        Completable.fromAction { repositoryDataSource.deleteCachedRepositories() }


    override fun getFactory(
        modelConverter: ConverterFactory
    ): DataSource.Factory<Int, RepositoryDisplayModel> =
        repositoryDataSource.getRepositoriesFactory(modelConverter)

    private fun saveItems(
        feedItems: List<RepositoryEntity>, username: String, isCached: Boolean
    ) {
        if (isCached) {
            feedItems.forEach { it.username = username }
            repositoryDataSource.insert(feedItems)
        } else {
            repositoryDataSource.insertAndClearCache(feedItems)
        }
    }
}
package com.kalashnyk.denys.oollatest.usecases.repository.data_source

import androidx.paging.DataSource
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.AppDatabase
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity
import com.kalashnyk.denys.oollatest.utils.ConverterFactory

interface RepositoryDataSource {

    fun getRepositoriesFactory(converterFactory: ConverterFactory)
            : DataSource.Factory<Int, RepositoryDisplayModel>

    fun deleteCachedRepositories()

    fun insert(repositoryItems: List<RepositoryEntity>)

    fun insertAndClearCache(repositoryItems: List<RepositoryEntity>)
}

class RepositoryDataSourceImpl(private val database: AppDatabase) : RepositoryDataSource {

    override fun getRepositoriesFactory(
        converterFactory: ConverterFactory
    ): DataSource.Factory<Int, RepositoryDisplayModel> {
        return database.repositoryDao().getDataSource()
            .mapByPage(converterFactory::convert)
    }

    override fun deleteCachedRepositories(): Unit=
        database.repositoryDao().deleteCachedItems()

    override fun insert(repositoryItems: List<RepositoryEntity>) : Unit=
        database.repositoryDao().insert(repositoryItems)

    override fun insertAndClearCache(repositoryItems: List<RepositoryEntity>): Unit=
        database.repositoryDao().insertAndClearCache(repositoryItems)
}
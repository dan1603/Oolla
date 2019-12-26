package com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source

import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity
import com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source.communicator.ServerCommunicator
import io.reactivex.Single
import retrofit2.Response

interface RepositoryRemoteDataSource {

    fun fetchRepositories(username: String): Single<Response<List<RepositoryEntity>>>

    fun fetchRepositoriesNext(username: String, lastItemId: Int): Single<Response<List<RepositoryEntity>>>
}

class RepositoryRemoteDataSourceImpl(private val serverCommunicator: ServerCommunicator) : RepositoryRemoteDataSource {

    override fun fetchRepositories(username: String): Single<Response<List<RepositoryEntity>>> =
        serverCommunicator.fetchRepositories(username = username, lastItemId=1)


    override fun fetchRepositoriesNext(username: String, lastItemId: Int): Single<Response<List<RepositoryEntity>>> =
        serverCommunicator.fetchRepositories(username = username, lastItemId=lastItemId)
}
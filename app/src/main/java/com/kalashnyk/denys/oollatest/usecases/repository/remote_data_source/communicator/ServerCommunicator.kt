package com.kalashnyk.denys.oollatest.usecases.repository.remote_data_source.communicator

import android.util.Log
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity
import io.reactivex.Single
import retrofit2.Response

const val ITEMS_PER_PAGE = 20

class ServerCommunicator(private val mService: ApiService) {

    fun fetchRepositories(username: String, lastItemId: Int): Single<Response<List<RepositoryEntity>>> {
        return mService.fetchRepositories(username, lastItemId, ITEMS_PER_PAGE)
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message) }
    }
}

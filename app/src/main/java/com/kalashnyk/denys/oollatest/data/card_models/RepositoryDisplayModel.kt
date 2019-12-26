package com.kalashnyk.denys.oollatest.data.card_models

import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity

class RepositoryDisplayModel(private var repositoryEntity : RepositoryEntity) {

    fun getRepositoryId(): String {
        return repositoryEntity.id.toString()
    }

    fun getBaseModel(): RepositoryEntity {
        return repositoryEntity
    }

}
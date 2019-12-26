package com.kalashnyk.denys.oollatest.utils

import com.kalashnyk.denys.oollatest.data.BaseModel
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity
import java.util.ArrayList

class ConverterFactory {

    fun convert(list: List<BaseModel>): List<RepositoryDisplayModel> {

        val items = ArrayList<RepositoryDisplayModel>()

        list.forEach {
            convert(it)?.apply {
                items.add(this)
            }
        }
        return items
    }

    private fun convert(item: BaseModel): RepositoryDisplayModel? {
        if(item is RepositoryEntity && item.isRepository){
            return RepositoryDisplayModel(item)
        }
        return null
    }
}

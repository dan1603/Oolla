package com.kalashnyk.denys.oollatest.data

import androidx.databinding.BaseObservable

abstract class BaseModel: BaseObservable() {
    abstract fun convertItemForDataSource(): BaseModel
}

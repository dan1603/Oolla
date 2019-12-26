package com.kalashnyk.denys.oollatest.usecases.repository.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.dao.RepositoryDao
import com.kalashnyk.denys.oollatest.usecases.repository.data_source.database.entity.RepositoryEntity

@Database(entities = [RepositoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
}
package com.kalashnyk.denys.oollatest.presentation.activities.main

import com.kalashnyk.denys.oollatest.presentation.fragments.search.SearchModel

interface MainListener {
    fun onRepositoryClicked(url: String)
    fun onSearchClicked(searchModel: SearchModel)
    fun openRepositoriesFragment(query: String)
}
package com.kalashnyk.denys.oollatest.presentation.fragments.search

import com.kalashnyk.denys.oollatest.presentation.activities.main.MainListener

class SearchModelBinding(
    private val searchModel: SearchModel,
    private val listener: MainListener
) {
    fun onSearchClick() {
        listener.onSearchClicked(searchModel)
    }
}
package com.kalashnyk.denys.oollatest.presentation.activities.main

import android.view.MenuItem
import com.kalashnyk.denys.oollatest.R
import com.kalashnyk.denys.oollatest.databinding.MainDataBinding
import com.kalashnyk.denys.oollatest.di.component.ViewModelComponent
import com.kalashnyk.denys.oollatest.presentation.base.BaseActivity
import com.kalashnyk.denys.oollatest.presentation.fragments.repositories.RepositoriesFragment
import com.kalashnyk.denys.oollatest.presentation.fragments.search.SearchFragment
import com.kalashnyk.denys.oollatest.presentation.fragments.search.SearchModel
import com.kalashnyk.denys.oollatest.utils.extention.openWebViewPage
import com.kalashnyk.denys.oollatest.utils.extention.replaceFragment

const val EXTRAS_USERNAME = "EXTRAS_USERNAME"

class MainActivity : BaseActivity<MainDataBinding>(),
    MainListener {

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setupViewLogic(binding: MainDataBinding) {
        openSearchFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {

                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRepositoryClicked(url: String) {
        openWebViewPage(url)
    }

    override fun onSearchClicked(searchModel: SearchModel) {
        openRepositoriesFragment(searchModel.query)
    }

    override fun openRepositoriesFragment(query : String) {
        this.replaceFragment(R.id.mainContent, RepositoriesFragment.newInstance(query), true, false)
    }

    private fun openSearchFragment() {
        this.replaceFragment(R.id.mainContent, SearchFragment.newInstance(), false, false)
    }
}

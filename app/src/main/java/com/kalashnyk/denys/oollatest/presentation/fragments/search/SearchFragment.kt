package com.kalashnyk.denys.oollatest.presentation.fragments.search

import com.kalashnyk.denys.oollatest.R
import com.kalashnyk.denys.oollatest.databinding.SearchDataBinding
import com.kalashnyk.denys.oollatest.presentation.activities.main.MainActivity
import com.kalashnyk.denys.oollatest.presentation.base.BaseFragment
import com.kalashnyk.denys.oollatest.utils.extention.hideKeyboardWithClearFocus

class SearchFragment : BaseFragment<SearchDataBinding>(), SearchCallback {

    private lateinit var searchModelBinding: SearchModelBinding

    private val searchModel = SearchModel()

    override fun getLayoutId(): Int = R.layout.fragment_search

    override fun setupViewLogic(binder: SearchDataBinding) {
        searchModelBinding = SearchModelBinding(searchModel, (requireActivity() as MainActivity))
        binder.bindingModel = searchModelBinding
        binder.etUserName.addTextChangedListener(SearchTextWatcher(this, searchModel, binder.etUserName))

        binder.btnSearch.setOnClickListener {
            it.hideKeyboardWithClearFocus()
            searchModelBinding.onSearchClick()
        }
        setupAppBar()
    }

    override fun enableSearchButton(flag: Boolean) {
        viewBinder.btnSearch.isEnabled = flag
    }

    private fun setupAppBar() = (activity as MainActivity).supportActionBar?.apply {
        setDisplayHomeAsUpEnabled(false)
        title = getString(R.string.app_title_search)
    }

    companion object {
        fun newInstance(): SearchFragment = SearchFragment()
    }
}

package com.kalashnyk.denys.oollatest.presentation.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedList
import com.kalashnyk.denys.oollatest.App
import com.kalashnyk.denys.oollatest.di.component.ViewModelComponent
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.recyclerview.widget.RecyclerView
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.presentation.adapter.paginglist.DiffCallbackBaseCardModel
import com.kalashnyk.denys.oollatest.presentation.adapter.paginglist.PagingAdapter
import com.kalashnyk.denys.oollatest.utils.multistate.MultiStateView

abstract class BasePagingFragment<V : ViewDataBinding>: BaseFragment<V>(), ItemsLoadListener<PagedList<RepositoryDisplayModel>> {

    protected var pagingAdapter: PagingAdapter = PagingAdapter(DiffCallbackBaseCardModel())

    abstract fun injectDependency(component: ViewModelComponent)

    abstract fun initListView()

    abstract fun getListView(): RecyclerView

    abstract fun getRefreshView(): SwipeRefreshLayout

    abstract fun getStateView() : MultiStateView

    abstract fun initObserver()

    abstract fun removeObserver()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        displayProgress()
        initListView()
        initObserver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    override fun onDestroyView() {
        removeObserver()
        super.onDestroyView()
    }

    private fun createDaggerDependencies() {
       activity?.apply { injectDependency((application as App).getViewModelComponent()) }
    }
}
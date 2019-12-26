package com.kalashnyk.denys.oollatest.presentation.adapter.paginglist

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.kalashnyk.denys.oollatest.R
import com.kalashnyk.denys.oollatest.data.card_models.RepositoryDisplayModel
import com.kalashnyk.denys.oollatest.databinding.ItemRepositoryBinding
import com.kalashnyk.denys.oollatest.presentation.activities.main.MainListener
import com.kalashnyk.denys.oollatest.presentation.fragments.repositories.RepositoryModelBinding

class PagingAdapter(diffUtil: DiffUtil.ItemCallback<RepositoryDisplayModel>) :
    MultiTypeDataBoundAdapter<RepositoryDisplayModel, ViewDataBinding>(diffUtil) {

    lateinit var listener: MainListener

    override fun getItemLayoutId(position: Int): Int {
        getItem(position)?.let {
            return R.layout.item_repository
        }
        return -1
    }

    override fun bindItem(
        holder: DataBoundViewHolder<ViewDataBinding>,
        position: Int,
        payloads: List<Any>
    ) {
        super.bindItem(holder, position, payloads)
        val item = getItem(position)
        if (holder.binding is ItemRepositoryBinding) {
            item?.let {
                holder.binding.bindingModel = RepositoryModelBinding(it, listener)
            }
        }
    }
}
package com.example.kitsugithub.data.base

import androidx.paging.PagingSource
import androidx.paging.PagingState

abstract class BasePagingSource <T : Any> : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    companion object{
        const val HEADLINE_PAGE = 1
    }
}
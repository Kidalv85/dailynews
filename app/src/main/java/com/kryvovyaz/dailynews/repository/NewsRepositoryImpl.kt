package com.kryvovyaz.dailynews.repository

import androidx.paging.PagingData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.kryvovyaz.dailynews.data.remote.NewsApi
import com.kryvovyaz.dailynews.data.remote.NewsPagingSource
import com.kryvovyaz.dailynews.domain.model.Article
import com.kryvovyaz.dailynews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}
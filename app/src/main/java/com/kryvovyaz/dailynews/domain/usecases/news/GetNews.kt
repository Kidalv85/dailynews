package com.kryvovyaz.dailynews.domain.usecases.news

import androidx.paging.PagingData
import com.kryvovyaz.dailynews.domain.model.Article
import com.kryvovyaz.dailynews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}
package com.kryvovyaz.dailynews.domain.usecases.news

import com.kryvovyaz.dailynews.data.local.NewsDao
import com.kryvovyaz.dailynews.domain.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedArticles @Inject constructor(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}
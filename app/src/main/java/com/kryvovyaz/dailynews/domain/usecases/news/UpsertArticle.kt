package com.kryvovyaz.dailynews.domain.usecases.news

import com.kryvovyaz.dailynews.data.local.NewsDao
import com.kryvovyaz.dailynews.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}
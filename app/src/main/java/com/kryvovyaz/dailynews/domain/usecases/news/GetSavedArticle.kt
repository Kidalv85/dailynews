package com.kryvovyaz.dailynews.domain.usecases.news

import com.kryvovyaz.dailynews.data.local.NewsDao
import com.kryvovyaz.dailynews.domain.model.Article
import javax.inject.Inject

class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}
package com.kryvovyaz.dailynews.data.remote.dto

import com.kryvovyaz.dailynews.domain.model.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)
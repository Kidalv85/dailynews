package com.kryvovyaz.dailynews.presentation.bookmark

import com.kryvovyaz.dailynews.domain.model.Article

data class BookmarkState (
    val articles : List<Article> = emptyList()
)
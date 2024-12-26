package com.kryvovyaz.dailynews.presentation.details

import com.kryvovyaz.dailynews.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()
}
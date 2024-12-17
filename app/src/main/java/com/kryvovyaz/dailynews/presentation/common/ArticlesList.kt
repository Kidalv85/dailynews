package com.kryvovyaz.dailynews.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.kryvovyaz.dailynews.domain.model.Article
import com.kryvovyaz.dailynews.presentation.Dimentions.padding_24
import com.kryvovyaz.dailynews.presentation.Dimentions.padding_6

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResults(articles = articles)
    if (handlePagingResult){
        LazyColumn (
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(padding_24),
            contentPadding = PaddingValues(padding_6)
        ){
            items(count = articles.itemCount){
                articles[it]?.let { 
                    ArticleCard(
                        article = it,
                        onClick = { onClick(it) }
                    )
                }
            }
        }
    }

}

@Composable
fun handlePagingResults(
    articles: LazyPagingItems<Article>,
): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }

}

@Composable
private fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(padding_24)) {
        repeat(10) {
            ArticleCardShimmerEffect(modifier = Modifier.padding(horizontal = padding_24))
        }
    }
}
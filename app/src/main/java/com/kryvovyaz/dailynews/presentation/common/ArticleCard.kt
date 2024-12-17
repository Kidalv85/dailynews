package com.kryvovyaz.dailynews.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kryvovyaz.dailynews.R
import com.kryvovyaz.dailynews.domain.model.Article
import com.kryvovyaz.dailynews.domain.model.Source
import com.kryvovyaz.dailynews.presentation.Dimentions.padding_2
import com.kryvovyaz.dailynews.presentation.Dimentions.padding_6
import com.kryvovyaz.dailynews.presentation.Dimentions.size_12
import com.kryvovyaz.dailynews.presentation.Dimentions.size_96
import com.kryvovyaz.dailynews.ui.theme.DailyNewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(size_96)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(horizontal = padding_2)
                .height(size_96),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = article.title ?: "No title",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(padding_6))
                Icon(
                    modifier = Modifier.size(size_12),
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(padding_6))
                Text(
                    text = article.publishedAt?:"No info",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    DailyNewsAppTheme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Just for the preview",
                url = "",
                urlToImage = ""
            )
        ) {

        }
    }

}
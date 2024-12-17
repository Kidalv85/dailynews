package com.kryvovyaz.dailynews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.kryvovyaz.dailynews.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Page1",
        description = "Page 1 description",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Page2",
        description = "Page 2 description",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Page3",
        description = "Page 3 description",
        image = R.drawable.onboarding3
    )
)
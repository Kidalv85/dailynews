package com.kryvovyaz.dailynews.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)
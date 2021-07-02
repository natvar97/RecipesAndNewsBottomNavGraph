package com.indialone.bottomnavgraphapp.api.news

data class NewsEntity(
    val totalResults: Int? = null,
    val articles: List<ArticlesItem?>? = null,
    val status: String? = null
)
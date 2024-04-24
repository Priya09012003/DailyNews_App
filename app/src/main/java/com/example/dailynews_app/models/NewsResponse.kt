package com.example.dailynews_app.models

import com.example.dailynews_app.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
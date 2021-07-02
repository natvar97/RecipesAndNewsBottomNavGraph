package com.indialone.bottomnavgraphapp.repository

import androidx.annotation.WorkerThread
import com.indialone.bottomnavgraphapp.api.dish.RetrofitBuilderDishes
import com.indialone.bottomnavgraphapp.api.news.RetrofitBuilderNews
import com.indialone.bottomnavgraphapp.utils.Constants

class ApiDataRepository {

    @WorkerThread
    suspend fun getRandomDishes() = RetrofitBuilderDishes.apiService
        .getRandomDishes(
            Constants.API_KEY_DISHES,
            Constants.QUERY_LIMIT_LICENSE_VALUE,
            Constants.QUERY_NUMBER_VALUE,
            Constants.QUERY_TAGS_VALUE
        )

    @WorkerThread
    suspend fun getTopHeadlinesTechCrunch() = RetrofitBuilderNews.newsApiService
        .getTopHeadlinesTechCrunch(
            Constants.QUERY_SOURCE_VALUE,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getTopHeadlines() = RetrofitBuilderNews.newsApiService
        .getTopHeadlines(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getAppleNews() = RetrofitBuilderNews.newsApiService
        .getAppleNews(
            Constants.Q_APPLE,
            Constants.FROM_APPLE,
            Constants.TO_APPLE,
            Constants.SORT_BY_APPLE,
            Constants.API_KEY_NEWS
        )

    @WorkerThread
    suspend fun getTeslaNews() = RetrofitBuilderNews.newsApiService
        .getTeslaNews(
            Constants.Q_TESLA,
            Constants.FROM,
            Constants.SORT_BY,
            Constants.API_KEY_NEWS
        )


    @WorkerThread
    suspend fun getWsjComNews() = RetrofitBuilderNews.newsApiService
        .getWsjComNews(
            Constants.DOMAINS,
            Constants.API_KEY_NEWS
        )

}
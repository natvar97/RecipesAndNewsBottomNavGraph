package com.indialone.bottomnavgraphapp.api

import com.indialone.bottomnavgraphapp.api.dish.Recipes
import com.indialone.bottomnavgraphapp.api.news.NewsEntity
import com.indialone.bottomnavgraphapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.DISHES_END_POINT)
    suspend fun getRandomDishes(
        @Query(Constants.QUERY_API_KEY) apiKey: String,
        @Query(Constants.QUERY_LIMIT_LICENSE) limitLicense: String,
        @Query(Constants.QUERY_NUMBER) number: String,
        @Query(Constants.QUERY_TAGS) tags: String
    ): Recipes

    @GET(Constants.NEWS_END_POINT)
    suspend fun getTopHeadlinesTechCrunch(
        @Query(Constants.QUERY_SOURCE) sources: String,
        @Query(Constants.QUERY_API_KEY) apiKey: String
    ): NewsEntity

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getTeslaNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity


    @GET("everything")
    suspend fun getAppleNews(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

    @GET("everything")
    suspend fun getWsjComNews(
        @Query("domains") domains: String,
        @Query("apiKey") apiKey: String
    ): NewsEntity

}
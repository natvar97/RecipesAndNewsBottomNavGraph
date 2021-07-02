package com.indialone.bottomnavgraphapp.api.news

import com.indialone.bottomnavgraphapp.api.ApiService
import com.indialone.bottomnavgraphapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderNews {

    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiService = getInstance().create(ApiService::class.java)

}
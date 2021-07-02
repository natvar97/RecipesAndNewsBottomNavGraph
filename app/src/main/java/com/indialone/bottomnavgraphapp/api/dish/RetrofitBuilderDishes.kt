package com.indialone.bottomnavgraphapp.api.dish

import com.indialone.bottomnavgraphapp.api.ApiService
import com.indialone.bottomnavgraphapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderDishes {

    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_DISHES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService = getInstance().create(ApiService::class.java)

}
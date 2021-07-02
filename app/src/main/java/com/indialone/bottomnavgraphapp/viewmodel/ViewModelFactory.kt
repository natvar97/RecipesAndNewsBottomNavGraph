package com.indialone.bottomnavgraphapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indialone.bottomnavgraphapp.repository.ApiDataRepository
import java.lang.IllegalArgumentException

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DishesViewModel::class.java)){
            return DishesViewModel(ApiDataRepository()) as T
        }
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(ApiDataRepository()) as T
        }
        throw IllegalArgumentException("Unknown view model found")
    }
}
package com.indialone.bottomnavgraphapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.bottomnavgraphapp.api.dish.Recipes
import com.indialone.bottomnavgraphapp.repository.ApiDataRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception


class DishesViewModel(
    private val repository : ApiDataRepository
) : ViewModel(){

    val dishes = MutableLiveData<Recipes>()

    init {
        fetchRandomDishes()
    }

    fun fetchRandomDishes() {
        viewModelScope.launch {
            try {
                val dishesList = async {
                    repository.getRandomDishes()
                }
                dishes.postValue(dishesList.await())
            } catch (e : Exception){}
        }
    }

    fun getRandomDishes() : LiveData<Recipes> {
        return dishes
    }

}
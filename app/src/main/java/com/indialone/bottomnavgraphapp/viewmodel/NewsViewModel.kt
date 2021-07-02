package com.indialone.bottomnavgraphapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indialone.bottomnavgraphapp.api.news.NewsEntity
import com.indialone.bottomnavgraphapp.repository.ApiDataRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: ApiDataRepository
) : ViewModel() {

    private val topHeadlines = MutableLiveData<NewsEntity>()
    private val techCrunchNews = MutableLiveData<NewsEntity>()
    private val appleNews = MutableLiveData<NewsEntity>()
    private val teslaNews = MutableLiveData<NewsEntity>()
    private val wsjComNews = MutableLiveData<NewsEntity>()

    init {
        fetchTopHeadlines()
        fetchTechCrunchNews()
        fetchAppleNews()
        fetchTeslaNews()
        fetchWsjComNews()
    }

    private fun fetchTechCrunchNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val newsList = async {
                        repository.getTopHeadlinesTechCrunch()
                    }
                    topHeadlines.postValue(newsList.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchWsjComNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getWsjComNews()
                    }
                    wsjComNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchTeslaNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getTeslaNews()
                    }
                    teslaNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchAppleNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getAppleNews()
                    }
                    appleNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async {
                        repository.getTopHeadlines()
                    }
                    techCrunchNews.postValue(news.await())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun getTopHeadlines(): LiveData<NewsEntity> = topHeadlines
    fun getTechCrunchNews(): LiveData<NewsEntity> = techCrunchNews
    fun getAppleNews(): LiveData<NewsEntity> = appleNews
    fun getTeslaNews(): LiveData<NewsEntity> = teslaNews
    fun getWsjComNews(): LiveData<NewsEntity> = wsjComNews

}
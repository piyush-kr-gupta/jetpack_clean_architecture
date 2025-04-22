package com.example.tweeter.repository

import com.example.tweeter.api.TweeterAPI
import com.example.tweeter.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private var tweeterAPI: TweeterAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList()) //?? "MutableStateFlow"
    val categories: StateFlow<List<String>> //?? "MutableStateFlow vs StateFlow"
        get() = _categories //?? "get()"

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


    suspend fun getCategories() {
        val response = tweeterAPI.getCategories()
        if(response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweeterAPI.getTweets(category)
        if(response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }

}
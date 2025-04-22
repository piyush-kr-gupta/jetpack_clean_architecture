package com.example.tweeter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweeter.models.TweetListItem
import com.example.tweeter.repository.TweetRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val tweetRepository: TweetRepository) :
    ViewModel() {
    val tweets: StateFlow<List<TweetListItem>>
        get() = tweetRepository.tweets

    init {
        viewModelScope.launch {
            tweetRepository.getTweets("DSA")
        }
    }
}
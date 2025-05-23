package com.example.tweeter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweeter.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //??
class CategoryViewModel @Inject constructor(private val tweetRepository: TweetRepository): ViewModel() {
    val categories: StateFlow<List<String>>
        get() = tweetRepository.categories

    init {
        viewModelScope.launch {
            tweetRepository.getCategories()
        }
    }
}
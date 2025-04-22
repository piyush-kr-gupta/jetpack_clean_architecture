package com.example.tweeter.api

import com.example.tweeter.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweeterAPI {
//    Simple GET request
//    @GET("/v3/b/680672628561e97a500470e2?meta=false")
//    suspend fun getTweets(category: String): Response<List<TweetListItem>>

    // GET request with headers (whatever category is passed will be passed as header as well)
    @GET("/v3/b/68079f768561e97a50050b5a?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/68079f768561e97a50050b5a?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}
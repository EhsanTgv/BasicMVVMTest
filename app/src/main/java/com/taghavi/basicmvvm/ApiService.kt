package com.taghavi.basicmvvm

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("image/random")
    suspend fun getRandomDog(): Response<ApiResponse>
}
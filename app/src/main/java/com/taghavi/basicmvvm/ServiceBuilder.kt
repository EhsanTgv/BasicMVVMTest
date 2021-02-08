package com.taghavi.basicmvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val API_URL = "https://dog.ceo/api/breeds/"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        provideRetrofit().create(ApiService::class.java)
    }
}
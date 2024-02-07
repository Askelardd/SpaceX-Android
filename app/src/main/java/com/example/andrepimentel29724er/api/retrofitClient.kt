package com.example.andrepimentel29724er.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitClient {
    private const val BASE_URL = "https://api.spacexdata.com/v4/"


    val spaceXAdapter: spaceXService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(spaceXService::class.java)
    }
}
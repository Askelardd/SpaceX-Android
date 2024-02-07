package com.example.andrepimentel29724er.api

import com.example.andrepimentel29724er.model.Crew
import retrofit2.Call
import retrofit2.http.GET

interface spaceXService {
    @GET("crew")
    fun getCrew(): Call<List<Crew>>
}


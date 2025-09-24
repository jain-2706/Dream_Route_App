package com.example.quiz_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_builder {
   private const val BASE_URL="https://api.data.gov/ed/collegescorecard/v1/"
    private fun getting_retrofit(): Retrofit
    {
        var r1= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return r1
    }
    fun get_api_service():Getting
    {
        return getting_retrofit().create(Getting::class.java)
    }


}
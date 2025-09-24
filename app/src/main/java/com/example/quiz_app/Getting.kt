package com.example.quiz_app
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Getting {
    //Getting the Data...
    @GET("schools.json")
    fun getData(
        @Query("api_key") apiKey: String,
        @Query("school.city") city: String,
        @Query("school.state") state: String,
        @Query("fields") fields: String = "school.name,school.city,school.state,latest.student.size",
        @Query("per_page") perPage: String = "20",

        ):Call<SchoolResponse>
}
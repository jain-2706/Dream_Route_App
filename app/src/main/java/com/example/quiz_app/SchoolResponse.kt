package com.example.quiz_app

import com.google.gson.annotations.SerializedName

data class SchoolResponse (
    @SerializedName("metadata") val metadata: Metadata,
    @SerializedName("results")
    var results: List<School>){
}
data class Metadata(
    @SerializedName("total") val total: Int = 0,
    @SerializedName("page") val page: Int = 0
    // Add other metadata fields as returned by API
)

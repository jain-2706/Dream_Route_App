package com.example.quiz_app

import com.google.gson.annotations.SerializedName

data class School (
    val id: Int = 0,
    @SerializedName("school.name")
    val name: String? = null,
    @SerializedName("school.city")
    val city: String? = null,
    @SerializedName("school.state")
    val state: String? = null,
    @SerializedName("latest.student.size")
    val studentSize: Int? = null,
    @SerializedName("latest.cost.attendance.academic_year")
    val academicCost: Int? = null
    )
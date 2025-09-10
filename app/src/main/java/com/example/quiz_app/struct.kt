package com.example.quiz_app
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
@Parcelize
data class struct(val question:String,val options: ArrayList<String>,val answer:String): Parcelable {
}
package com.example.quiz_app

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sq_lite_class_for_counsellor(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Counsellor_Database"
        const val TABLE_NAME="Counsellor"
    }
    override fun onCreate(db: SQLiteDatabase?) {
       var query="CREATE TABLE Counsellor(" +
               email S
               ")"
               db.execSQL(query)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }

}
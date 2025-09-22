package com.example.quiz_app
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sq_lite_class_for_students(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Student_Database"
        const val TABLE_NAME="student"
        const val Username="Username"
        const val Email="Email"
        const val Password="Password"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        var query: String="""
            CREATE TABLE student(
        id PRIMARY KEY AUTO_INCREMENT,
        Username VARCHAR(50) NOT NULL,
        Email VARCHAR(100) NOT NULL UNIQUE,
        Password TEXT NOT NULL)"""
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var query:String="""DROP TABLE IF EXISTS student"""
        db?.execSQL(query)
    }
    fun add_new_user(user:String,email:String,password:String){
         var sqll= this.writableDatabase
         val cv= ContentValues()
         cv.put(Username,user)
         cv.put(Email,email)
         cv.put(Password,password)
         sqll.insert(TABLE_NAME,null,cv)
    }
    fun delete_new_user(email:String,password: String){

    }
    fun update_new_user(old_email:String,old_password:String,new_email:String,new_password:String){

    }




}
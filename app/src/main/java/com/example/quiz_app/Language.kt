package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Language : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var eng=findViewById<CardView>(R.id.english)
        var hindi=findViewById<CardView>(R.id.hindi)
        eng.setOnClickListener {
            var intent= Intent(this@Language, MainActivity::class.java)
            intent.putExtra("lang",0)
            startActivity(intent)
        }
        hindi.setOnClickListener{
            var intent= Intent(this@Language, MainActivity::class.java)
            intent.putExtra("lang",1)
            startActivity(intent)
        }

    }
}
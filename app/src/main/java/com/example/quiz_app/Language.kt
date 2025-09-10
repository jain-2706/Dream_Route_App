package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Language : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var eng=findViewById<Button>(R.id.english)
        var hindi=findViewById<Button>(R.id.hindi)
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
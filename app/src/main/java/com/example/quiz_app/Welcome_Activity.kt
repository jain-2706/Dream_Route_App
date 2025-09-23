package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Welcome_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainlayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var shared_preferences=getSharedPreferences("User",MODE_PRIVATE)
        var check=shared_preferences.getBoolean("login",false)
        if(check==false)
        {
            Handler(Looper.getMainLooper()).postDelayed({
                var intt = Intent(this@Welcome_Activity, Login_Activity::class.java)
                startActivity(intt)
            },2000
            )
        }
        else
        {
            Handler(Looper.getMainLooper()).postDelayed({
                var intt = Intent(this@Welcome_Activity, Dashboard_UI::class.java)
                startActivity(intt)
            },2000
            )
        }
    }
}
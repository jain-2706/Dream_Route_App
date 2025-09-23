package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard_UI : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_ui)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var quiz_started=findViewById<Button>(R.id.confused_btn)
        quiz_started.setOnClickListener {
            var intent= Intent(this,Language::class.java)
            startActivity(intent)
        }

        var logout_text=findViewById<TextView>(R.id.logout_text)
        logout_text.setOnClickListener {
            var shared_pref=this.getSharedPreferences("User",MODE_PRIVATE)
            var shared_pref_edit=shared_pref.edit()
            shared_pref_edit.putBoolean("login",false)
            shared_pref_edit.apply()
            var intent= Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}
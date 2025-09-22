package com.example.quiz_app

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sign_up_activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var regisBtn=findViewById<Button>(R.id.register)
        var radio_group=findViewById<RadioGroup>(R.id.radio_group)
        var username=findViewById<EditText>(R.id.username)
        var email=findViewById<EditText>(R.id.email)
        var password=findViewById<EditText>(R.id.password)
        regisBtn.setOnClickListener {
           var username_text=username.text
            var email_text=email.text
            var password_text=password.text
            if(username_text.isEmpty()||email_text.isEmpty()||password_text.isEmpty())
            {
                Toast.makeText(this@Sign_up_activity,"Pls Enter all Fields Carefully",Toast.LENGTH_LONG).show()
            }
            else
            {
                var dbhandler=DBHa
            }
        }
    }
}
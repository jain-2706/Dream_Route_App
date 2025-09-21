package com.example.quiz_app

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var loginBtn=findViewById<Button>(R.id.loginBtn)
        var radio_group=findViewById<RadioGroup>(R.id.radio_group)

        loginBtn.setOnClickListener {
            var seleced_id=radio_group.checkedRadioButtonId
            var selected_radiobutton=findViewById<RadioButton>(seleced_id)
            if(selected_radiobutton.text=="Student")
            {

            }
            else if(selected_radiobutton.text=="Parent")
            {

            }
            else if(selected_radiobutton.text=="login")
            {

            }
        }

    }
}
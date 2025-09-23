package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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
        var email=findViewById<EditText>(R.id.email)
        var password=findViewById<EditText>(R.id.password)
        loginBtn.setOnClickListener {
            var selected_id=radio_group.checkedRadioButtonId
            var selected_radiobutton=findViewById<RadioButton>(selected_id)
            var email_text=email.text.toString()
            var password_text=password.text.toString()
            if(email_text.isEmpty()||password_text.isEmpty()||selected_id==-1)
            {
                Toast.makeText(this,"Pls Fill all Fields Carefully⚠️⚠️⚠️",Toast.LENGTH_LONG).show()
            }
            else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email_text).matches()) {
                email.setError("Please enter a valid email");
                email.requestFocus();
            }
            else {
                if (selected_radiobutton.text == "Student") {
                    var arr = Sq_lite_class_for_students(this).select_new_user()
                    var f = 0;
                    for (i in 0 until arr.size) {
                        if (arr[i].email == email_text && arr[i].password == password_text) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 0) {
                        Toast.makeText(
                            this@Login_Activity,
                            "Email or Password not exists",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        var shared=getSharedPreferences("User",MODE_PRIVATE)
                        var shared_edit=shared.edit {
                            putBoolean("login",true)
                            apply()
                        }

                        var intent = Intent(this@Login_Activity, Language::class.java)
                        startActivity(intent)
                    }

                } else if (selected_radiobutton.text == "Parent") {
                    var arr = Sq_lite_class_for_parent(this).select_new_user()
                    var f = 0;
                    for (i in 0 until arr.size) {
                        if (arr[i].email == email_text && arr[i].password == password_text) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 0) {
                        Toast.makeText(
                            this@Login_Activity,
                            "Email or Password not exists",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else if (selected_radiobutton.text == "Counsellor") {
                    var arr = Sq_lite_class_for_counsellor(this).select_new_user()
                    var f = 0;
                    for (i in 0 until arr.size) {
                        if (arr[i].email == email_text && arr[i].password == password_text) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 0) {
                        Toast.makeText(
                            this@Login_Activity,
                            "Email or Password not exists",
                            Toast.LENGTH_LONG
                        ).show()
                    }


                }
            }
        }
        var link=findViewById<TextView>(R.id.link)
        link.setOnClickListener {
            var intent=Intent(this@Login_Activity, Sign_up_activity::class.java)
            startActivity(intent)
        }


    }
}
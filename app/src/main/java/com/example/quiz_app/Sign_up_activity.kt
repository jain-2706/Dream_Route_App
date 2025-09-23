package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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
            var selected_option=radio_group.checkedRadioButtonId
            var selected_option_id=findViewById<RadioButton>(selected_option)
           var username_text=username.text.toString()
            var email_text=email.text.toString()
            var password_text=password.text.toString()
            if(username_text.isEmpty()||email_text.isEmpty()||password_text.isEmpty()||selected_option==-1)
            {
                Toast.makeText(this@Sign_up_activity,"Pls Fill all Fields Carefully ⚠️⚠️⚠️",Toast.LENGTH_LONG).show()
            }
            else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email_text).matches()) {
                email.setError("Please enter a valid email");
                email.requestFocus();
            }
            else if(username_text.length<4)
            {
                username.setError("Username must be at least 4 characters long")
                username.requestFocus()
            }
            else if(password_text.length<6)
            {
                password.setError("Password must be at least 6 characters long")
                password.requestFocus()
            }
            else
            {
              if(selected_option_id.text=="Student")
              {
                   var sq_lite_class_for_student= Sq_lite_class_for_students(this)
                   var arr=sq_lite_class_for_student.select_new_user()
                    var f = 0;
                    for (i in 0 until arr.size) {
                      if (arr[i].email == email_text) {
                          f = 1;
                          break;
                      }
                  }
                  if (f == 1) {
                      Toast.makeText(
                          this@Sign_up_activity,
                          "Email already exists",
                          Toast.LENGTH_LONG
                      ).show()
                  }
                  else {
                      sq_lite_class_for_student.add_new_user(
                          username_text,
                          email_text,
                          password_text
                      )
                  }

                      var intent= Intent(this@Sign_up_activity, Dashboard_UI::class.java)
                      startActivity(intent)

              }
                else if(selected_option_id.text=="Parent")
              {
                  var sq_lite_class_for_parent= Sq_lite_class_for_parent(this)
                  var arr=sq_lite_class_for_parent.select_new_user()
                  var f = 0;
                  for (i in 0 until arr.size) {
                      if (arr[i].email == email_text) {
                          f = 1;
                          break;
                      }
                  }
                  if (f == 1) {
                      Toast.makeText(
                          this@Sign_up_activity,
                          "Email already exists",
                          Toast.LENGTH_LONG
                      ).show()

                  }
                  else {
                      sq_lite_class_for_parent.add_new_user(
                          username_text,
                          email_text,
                          password_text
                      )
                  }

                      var intent= Intent(this@Sign_up_activity, Language::class.java)
                      startActivity(intent)
              }
                else if(selected_option_id.text=="Counsellor")
              {
                  var sq_lite_class_for_counsellor= Sq_lite_class_for_counsellor(this)
                  var arr=sq_lite_class_for_counsellor.select_new_user()
                  var f = 0;
                  for (i in 0 until arr.size) {
                      if (arr[i].email == email_text) {
                          f = 1;
                          break;
                      }
                  }
                  if (f == 1) {
                      Toast.makeText(
                          this@Sign_up_activity,
                          "Email already exists",
                          Toast.LENGTH_LONG
                      ).show()

                  }
                  else {
                      sq_lite_class_for_counsellor.add_new_user(
                          username_text,
                          email_text,
                          password_text
                      )
                  }
                    var shared=getSharedPreferences("User",MODE_PRIVATE)
                  var shared_edit=shared.edit {
                      putBoolean("login",true)
                      apply()
                  }
                      var intent= Intent(this@Sign_up_activity, Language::class.java)
                      startActivity(intent)

              }
            }
        }
    }
}
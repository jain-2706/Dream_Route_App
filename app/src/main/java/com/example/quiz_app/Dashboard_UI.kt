package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call


class Dashboard_UI : AppCompatActivity() {


    var f=1

    private val BASE_URL = "https://api.data.gov/ed/collegescorecard/v1/"
    private val API_KEY = "CQfh2hdaovB9PCs26yolpfaxEtemcMSM9kmT5Iq6"
   lateinit var collegeSearchFormLayout: LinearLayout
    lateinit var collegeDetailsLayout: LinearLayout
    lateinit var cityEdit: EditText
    lateinit var stateEdit:EditText
    lateinit var courseEdit:EditText
    lateinit var searchButton :Button


    lateinit var explore_colleges_button :Button

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
        collegeSearchFormLayout= findViewById(R.id.college_search_form_layout)
         collegeDetailsLayout = findViewById<LinearLayout>(R.id.college_details_layout)
        cityEdit = findViewById<EditText>(R.id.city_edit_text)
        stateEdit= findViewById<EditText>(R.id.state_edit_text)

        searchButton= findViewById<Button>(R.id.search_button)

        explore_colleges_button= findViewById<Button>(R.id.explore_colleges_button)
        var quiz_started = findViewById<Button>(R.id.confused_btn)
        quiz_started.setOnClickListener {
            var intent = Intent(this, Language::class.java)
            startActivity(intent)
        }

        var logout_text = findViewById<TextView>(R.id.logout_text)
        logout_text.setOnClickListener {
            var shared_pref = this.getSharedPreferences("User", MODE_PRIVATE)
            var shared_pref_edit = shared_pref.edit()
            shared_pref_edit.putBoolean("login", false)
            shared_pref_edit.apply()
            var intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }
        explore_colleges_button.setOnClickListener {
            f=0

            collegeSearchFormLayout.visibility = View.VISIBLE
            explore_colleges_button.visibility = View.GONE
            searchButton.setOnClickListener {
                var cityEditText = cityEdit.text.toString().trim()
                var stateEditText = stateEdit.text.toString().trim()
                if (cityEditText.isNotEmpty() && stateEditText.isNotEmpty()) {
                    fetchCollegeData(cityEditText, stateEditText)
                } else {
                    Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun fetchCollegeData(city: String, state: String) {
        // Retrofit and API call logic as provided in previous answers
        // ... (This section remains the same) ...

        //Now Get The Data
        val fieldsToRetrieve =
            "id,school.name,school.city,school.state,latest.student.size,latest.cost.attendance.academic_year"
        val ca = Retrofit_builder.get_api_service()
            .getData(API_KEY, city, state, fieldsToRetrieve)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerColleges)
        recyclerView.layoutManager = LinearLayoutManager(this@Dashboard_UI)

        val list = mutableListOf<School>()
        val adapter = CollegeAdapter(list)
        recyclerView.adapter = adapter
        ca.enqueue(object : Callback<SchoolResponse> {
            override fun onResponse(
                call: Call<SchoolResponse>,
                response: Response<SchoolResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    collegeSearchFormLayout.visibility = View.VISIBLE
                    explore_colleges_button.visibility = View.GONE
                    collegeDetailsLayout.visibility = View.VISIBLE
                    var sr = response.body()
                    if (sr != null) {
                        var newlist = sr?.results ?: emptyList()
                        if (newlist.isNotEmpty()) {
                            collegeSearchFormLayout.visibility = View.GONE
                            explore_colleges_button.visibility = View.GONE
                            collegeDetailsLayout.visibility = View.VISIBLE
                            list.clear()
                            list.addAll(newlist)
                            adapter.notifyDataSetChanged()
                        }
                    } else {
                        // Clear fields and show a message if no results are found
                        Toast.makeText(this@Dashboard_UI, "No colleges found.", Toast.LENGTH_LONG)
                            .show()
                    }

                } else {
                    Toast.makeText(this@Dashboard_UI, "No response/invalid data", Toast.LENGTH_LONG)
                        .show()
                    val errorBody = response.errorBody()?.string()
                    Log.d("API_ERROR", "Error code: ${response.code()}, Error body: $errorBody")
                    Toast.makeText(this@Dashboard_UI, "Error: $errorBody", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(
                call: Call<SchoolResponse?>,
                t: Throwable
            ) {
                collegeDetailsLayout.visibility = View.GONE
                Toast.makeText(this@Dashboard_UI, "Network Error: ${t.message}", Toast.LENGTH_LONG)
                    .show()
                Log.d("Error", t.message.toString())
            }
        })
    }

    override fun onBackPressed() {
        if(f==0)
        {
            collegeSearchFormLayout.visibility = View.VISIBLE
            f=1
        }
        else {
            finishAffinity()

        }

    }
}
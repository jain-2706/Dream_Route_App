package com.example.quiz_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Actual_Quiz_UI : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_actual_quiz_ui)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txt_to_set=findViewById<TextView>(R.id.domain);
        var recyclerView: RecyclerView=findViewById<RecyclerView>(R.id.recycler_view);
        var getting_list=intent;
        var li=getting_list.getParcelableArrayListExtra<struct>("Subject_List")?: arrayListOf();
        var lan=intent.getIntExtra("lang",0)
        var language_selected=intent.getStringExtra("language_selected")
        if(li== Data_from_json(this).math_domainlist)
        {
            txt_to_set.setText("Maths")
        }
        else if(li== Data_from_json(this).science_domainlist)
        {
            txt_to_set.setText("Science")
        }
        else if(li== Data_from_json(this).arts_domainlist)
        {
            txt_to_set.setText("Arts")
        }
       else if(li== Data_from_json(this).commerce_domainlist)
        {
            txt_to_set.setText("Commerce")
        }
        else if(li== Data_from_json(this).math_hindi_list)
        {
            txt_to_set.setText("गणित")
        }
        else if(li== Data_from_json(this).science_hindi_list)
        {
            txt_to_set.setText("विज्ञान")
        }
        else if(li== Data_from_json(this).arts_hindi_list)
        {
            txt_to_set.setText("कला")
        }
        else if(li== Data_from_json(this).commerce_hindi_list)
        {
            txt_to_set.setText("वाणिज्य")
        }

        var correct:Int=0
        var wrong:Int=0
        var question_no=findViewById<TextView>(R.id.question_no);
        var seek_b=findViewById<SeekBar>(R.id.seek_b);
        var count_progress=findViewById<TextView>(R.id.progress)
        var structure= structure_of_recycler_view(this@Actual_Quiz_UI,li,0,question_no,seek_b,count_progress,correct,wrong,lan,language_selected);
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=structure
        structure.filter()



    }
}
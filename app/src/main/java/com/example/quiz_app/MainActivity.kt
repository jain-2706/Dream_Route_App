package com.example.quiz_app

import android.view.animation.AnimationUtils

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz_app.ui.theme.Quiz_AppTheme

import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.net.Uri

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main);
        var lan=intent.getIntExtra("lang",6)
        if(lan==0) {
            val textView = findViewById<TextView>(R.id.subtext)
            // HTML string with highlight
            val htmlText = "Answer a few quick questions to find out whether " +
                    "<b>Maths, Science, Arts </b> or <b>Commerce</b> suits your best"
            // Set HTML text to TextView
            textView.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
        }
        else
        {
            val textView = findViewById<TextView>(R.id.subtext)
            val htmlText = "कुछ त्वरित प्रश्नों का उत्तर दें ताकि पता चल सके कि " +
                    "<b>गणित, विज्ञान, कला</b> या <b>वाणिज्य</b> आपके लिए सबसे उपयुक्त है"
            textView.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
        }
        var maths: Button=findViewById<Button>(R.id.maths);
        var science: Button=findViewById<Button>(R.id.science);
        var arts: Button=findViewById<Button>(R.id.arts);
        var commerce: Button=findViewById<Button>(R.id.commerce);
        if(lan==0)
        {
            maths.setText("Maths")
            science.setText("Science")
            arts.setText("Arts")
            commerce.setText("Commerce")
        }
        else
        {
            maths.setText("गणित")
            science.setText("विज्ञान")
            arts.setText("कला")
            commerce.setText("वाणिज्य")
        }

        maths.setOnClickListener {
            var intent= Intent(this@MainActivity, Actual_Quiz_UI::class.java)
            if(lan==0) {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).math_domainlist
                );
                intent.putExtra("lang",0)
                intent.putExtra("language_selected","maths");
            }
            else
            {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).math_hindi_list
                );
                intent.putExtra("lang",1)
                intent.putExtra("language_selected","गणित");

            }
            startActivity(intent)
        }
        science.setOnClickListener { it->
            var intent= Intent(this@MainActivity, Actual_Quiz_UI::class.java)
            if(lan==0) {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).science_domainlist
                );
                intent.putExtra("lang",0)
                intent.putExtra("language_selected","science");
            }
            else
            {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).science_hindi_list
                );
                intent.putExtra("lang",1)
                intent.putExtra("language_selected","विज्ञान");
            }
            startActivity(intent)
        }
        arts.setOnClickListener { it->
            var intent= Intent(this@MainActivity, Actual_Quiz_UI::class.java)
            if(lan==0) {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).arts_domainlist
                );
                intent.putExtra("lang",0)
                intent.putExtra("language_selected","arts");
            }
            else
            {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).arts_hindi_list
                );
                intent.putExtra("lang",1)
                intent.putExtra("language_selected","कला");
            }

            startActivity(intent)
        }
        commerce.setOnClickListener { it->
            var intent= Intent(this@MainActivity, Actual_Quiz_UI::class.java)
            if(lan==0) {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).commerce_domainlist
                );
                intent.putExtra("lang",0)
                intent.putExtra("language_selected","commerce");
            }
            else
            {
                intent.putParcelableArrayListExtra(
                    "Subject_List",
                    Data_from_json(this@MainActivity).commerce_hindi_list
                );
                intent.putExtra("lang",1)
                intent.putExtra("language_selected","वाणिज्य");
            }
            startActivity(intent)
        }

        maths.setOnTouchListener { v, event ->
            touching(v,event)
        }

        science.setOnTouchListener {v,event->
            touching(v,event)
        }


        arts.setOnTouchListener { v, event ->
            touching(v,event)
        }
        commerce.setOnTouchListener { v, event ->
            touching(v,event)
        }
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data
    }
    fun touching(v: View,event: MotionEvent): Boolean
    {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                v.setBackgroundColor(Color.LTGRAY)
                v.translationX=-5f
                v.translationY=-25f
            }
            MotionEvent.ACTION_UP-> {
                v.setBackgroundColor(Color.WHITE)
                v.translationX=0f
                v.translationY=0f
            }
        }

       return false
    }


}


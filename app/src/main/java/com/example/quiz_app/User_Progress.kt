package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import android.graphics.Color
import android.text.Html
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.example.quiz_app.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class User_Progress : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_progress)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txt_ge=findViewById<TextView>(R.id.gemini_text)

        var lan=intent.getIntExtra("lang",0)
        var correct=intent.getIntExtra("Correct",0)
        var wrong=intent.getIntExtra("Wrong",0)
        var total=correct+wrong
        setting_progress(correct,wrong,total,txt_ge,lan)
        var bar_data_set= BarDataSet(getting(correct,wrong),"Quiz Stats").apply {
            valueTextSize=10f
            colors=mutableListOf<Int>(Color.GREEN,Color.RED,Color.BLUE)
        }

        var bar_chart=findViewById<BarChart>(R.id.bar_chart).apply {
            data= BarData(bar_data_set)
            data.barWidth=0.78f
            animateY(2000)
            description.isEnabled=false
            legend.isEnabled=false
        }
        var x_ax=bar_chart.xAxis
        if(lan==0) {
            x_ax.valueFormatter =
                IndexAxisValueFormatter(listOf<String>("Correct", " ", "Wrong", " ", "Accuracy"))
        }
        else
        {
            x_ax.valueFormatter =
                IndexAxisValueFormatter(listOf<String>("सही", " ", "गलत", " ", "सटीकता"))
        }
        x_ax.position= XAxis.XAxisPosition.BOTTOM
        x_ax.granularity = 1f




    }
    fun getting(correct:Int,wrong:Int):ArrayList<BarEntry>
    {
        var bar_entry_list = ArrayList<BarEntry>();
        if((correct+wrong)>0) {
                 var accuracy = ((correct*100) / (correct + wrong))
                bar_entry_list.add(BarEntry(0f,correct.toFloat()))
                bar_entry_list.add(BarEntry(2f,wrong.toFloat()))
                bar_entry_list.add(BarEntry(4f,accuracy.toFloat()))
        }
        return bar_entry_list
    }
    fun setting_progress(correct:Int,wrong:Int,total:Int,txt_gemini: TextView,lan:Int) {
        val model = GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = BuildConfig.API_KEY
        )
        var prompt: String
           if(lan==0) {
               prompt = """
            A student has completed a quiz.
            Total Questions: $total
            Correct: $correct
            Wrong: $wrong
            
            Please give:
             Please respond in **valid HTML**:
            1.Pls give performance summary
            2. One tip to improve for the next quiz.
            3.Pls give some attractive material also
            4:Pls add some emojis also
            5:Pls highlight some text in between to look it attractive
            6..The Text which you will give in that highlight some important words
            7..- Add at least one <b>highlighted phrase</b> for encouragement.
            8..Use <font color="red" for some important text
    - Use <h2> or <h3> for headings (#).
    - Use <p> for short motivational summary.
    - Give 1 improvement tip in <li>.
    - Add at least one <b>highlighted phrase</b> for encouragement.
    - Add a small decorative emoji ⭐ or 🎯.
   
            
            
        """.trimIndent()
           }
        else
           {
               prompt = """
                   Pls generate all response in hindi 🙏🙏
            A student has completed a quiz.
            Total Questions: $total
            Correct: $correct
            Wrong: $wrong
            
            Please give:
             Please respond in **valid HTML**:
            1.Pls give performance summary
            2. One tip to improve for the next quiz.
            3.Pls give some attractive material also
            4:Pls add some emojis also
            5:Pls highlight some text in between to look it attractive
            6..The Text which you will give in that highlight some important words
            7..- Add at least one <b>highlighted phrase</b> for encouragement.
            8..Use <font color="red" for some important text
    - Use <h2> or <h3> for headings (#).
    - Use <p> for short motivational summary.
    - Give 1 improvement tip in <li>.
    - Add at least one <b>highlighted phrase</b> for encouragement.
    - Add a small decorative emoji ⭐ or 🎯.
   
            
            
        """.trimIndent()
           }
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = model.generateContent(prompt)
                val reply = response.text ?: "No feedback available"
                val cleanReply = reply.replace(Regex("```[a-zA-Z]*"), "").replace("```", "").trim()
                withContext(Dispatchers.Main) {
                   txt_gemini.text = Html.fromHtml(cleanReply, Html.FROM_HTML_MODE_LEGACY)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    txt_gemini.text = "Error: ${e.message}"
                }
            }
        }
    }

}
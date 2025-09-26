package com.example.quiz_app
import android.os.Bundle
import com.example.quiz_app.BuildConfig
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_app.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Roadmap_Activity : AppCompatActivity() {

    // Declare your UI elements
    private lateinit var classEditText: EditText
    private lateinit var streamEditText: EditText
    private lateinit var careerEditText: EditText
    private lateinit var domainEditText: EditText
    private lateinit var generateButton: Button
    private lateinit var roadmap_webview: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roadmap)
        classEditText=findViewById(R.id.inputClass)
        streamEditText=findViewById(R.id.inputStream)
        careerEditText=findViewById(R.id.inputCareer)
        domainEditText=findViewById(R.id.inputDomain)
        generateButton=findViewById(R.id.generateBtn)
        roadmap_webview=findViewById(R.id.roadmapWebView)
        roadmap_webview.settings.javaScriptEnabled=true
        roadmap_webview.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        generateButton.setOnClickListener {

            var stream=streamEditText.text.toString()
            var career=careerEditText.text.toString()
            var domain=domainEditText.text.toString()
            var class_p= classEditText.text.toString()

            val user_input="""
            Class:${class_p},
            Stream:${stream}.
            Domain:${domain},
            Career:${career}
        """.trimIndent()
         setting_progress(user_input)
        }
    }
    fun setting_progress(user_input:String) {
        roadmap_webview=findViewById(R.id.roadmapWebView)
        val model = GenerativeModel(
            modelName = "gemini-2.5-pro",
            apiKey = BuildConfig.API_KEY
        )
        val prompt = """
            You are a career roadmap generator.
            User input: ${user_input}
          Generate ONLY a Mermaid.js flowchart starting with "graph TD".
          Do NOT add explanations or extra text.
          Use concise node titles and connect them with arrows.
        """.trimIndent()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = model.generateContent(prompt)
                val reply = response.text ?: "No feedback available"
                val graphStartIndex = reply.indexOf("graph")
                val cleanReply = if (graphStartIndex >= 0) {
                    reply.substring(graphStartIndex).trim()
                } else {
                    "graph TD; No valid graph found"
                }
                withContext(Dispatchers.Main) {
                    var ans=buildMermaidHtml(cleanReply)
                    roadmap_webview.loadDataWithBaseURL(null, ans, "text/html", "UTF-8", null)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                   Log.e("Error","Dikkat",e)
                }
            }
        }}
    private fun buildMermaidHtml(graph: String): String {
            return """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="utf-8">
              <script src="https://cdn.jsdelivr.net/npm/mermaid/dist/mermaid.min.js"></script>
              <script>
                mermaid.initialize({ startOnLoad: true, theme: 'forest' });
              </script>
            </head>
            <body>
              <div class="mermaid">
                $graph
              </div>
            </body>
            </html>
        """
        }



}
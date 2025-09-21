//package com.example.quiz_app
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class career_and_resources_activity : AppCompatActivity() {
//    //Making the Career Lists
//    var maths_career_list=mutableListOf("Data Analyst", "Actuary", "Software Developer")
//    var science_career_list=mutableListOf("Doctor", "Pharmacist", "Researcher")
//    var arts_career_list=mutableListOf("Writer", "Painter", "Designer")
//    var commerce_career_list=mutableListOf("Accountant", "Investment Banker", "Auditor")
//    var maths_hindi_career_list = mutableListOf("डेटा विश्लेषक", "एक्चुअरी", "सॉफ़्टवेयर डेवलपर")
//    var science_hindi_career_list = mutableListOf("डॉक्टर", "फार्मासिस्ट", "शोधकर्ता")
//    var arts_hindi_career_list = mutableListOf("लेखक", "चित्रकार", "डिज़ाइनर")
//    var commerce_hindi_career_list = mutableListOf("लेखाकार", "निवेश बैंकर", "लेखा परीक्षक")
//
//
//    //Making the resources list
//    var maths_resource_list=mutableListOf("Khan Academy" to "https://www.khanacademy.org/math",
//        "Brilliant.org" to "https://brilliant.org/",
//        "Coursera Math" to "https://www.coursera.org/browse/math-and-logic")
//    var science_resource_list=mutableListOf(
//        "MIT OpenCourseWare" to "https://ocw.mit.edu/",
//        "Coursera Science" to "https://www.coursera.org/browse/physical-science-and-engineering"
//    )
//    var arts_resource_list=mutableListOf(
//        "Skillshare" to "https://www.skillshare.com/browse/art",
//        "Udemy Arts" to "https://www.udemy.com/courses/design/"
//    )
//    var commerce_resource_list=mutableListOf("edX Business" to "https://www.edx.org/learn/business",
//        "Coursera Finance" to "https://www.coursera.org/browse/business/finance")
//
//    var maths_hindi_resources = mutableListOf(
//        "PVRstudy प्रयागराज" to "https://www.youtube.com/watch?v=CVomAoyHnB4",
//        "Easy Math With Minahil Khan" to "https://www.youtube.com/c/Minahilkhan",
//        "Mathematics for Data Science and Machine Learning" to "https://www.youtube.com/watch?v=yDzJ4tgaN7A"
//    )
//    var science_hindi_resources = mutableListOf(
//        "Vigyan TV India" to "https://www.youtube.com/c/VigyanTvIndia",
//        "GetFlyScience" to "https://www.youtube.com/c/GetFlyScience",
//        "Science Wale" to "https://www.youtube.com/c/ScienceWale"
//    )
//    var arts_hindi_resources = mutableListOf(
//        "Artist Reyanshh Rahul" to "https://www.youtube.com/@reyanshh_rahul",
//        "Indian Artist" to "https://www.youtube.com/c/IndianArtistYouTube",
//        "Nisha's Art Classes India" to "https://www.youtube.com/channel/UCOzHjGQAEXYbGxh2E6U0ebQ"
//    )
//    var commerce_hindi_resources = mutableListOf(
//        "Commerce Wale Guruji" to "https://www.youtube.com/c/CommerceWaleGuruJi",
//        "Study with Sudhir" to "https://www.youtube.com/c/StudyWithSudhir",
//        "CA Rachana Phadke Ranade" to "https://www.youtube.com/c/CARachanaPhadkeRanade"
//    )
//
//
//
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_career_and_resources)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        var language= intent.getStringExtra("language_selected")
//        var container=findViewById<LinearLayout>(R.id.container)
//        var domain: TextView
//
//        val career_list=when(language)
//        {
//            "maths"->maths_career_list
//            "science"->science_career_list
//            "arts"->arts_career_list
//            "commerce"->commerce_career_list
//            "गणित"->maths_hindi_career_list
//             "विज्ञान"->science_hindi_career_list
//             "कला"->arts_hindi_career_list
//            "वाणिज्य"->commerce_hindi_career_list
//            else->mutableListOf()
//        }
//        val resources_list=when(language)
//        {
//            "maths"->maths_resource_list
//            "science"->science_resource_list
//            "arts"->arts_resource_list
//            "commerce"->commerce_resource_list
//            "गणित"->maths_hindi_resources
//            "विज्ञान"->science_hindi_resources
//            "कला"->arts_hindi_resources
//            "वाणिज्य"->commerce_hindi_resources
//            else->mutableListOf()
//        }
//
//        domain= TextView(this).apply {
//            text = language
//
//
//        }
//        container.addView(domain)
//
//        var career_options=TextView(this).apply{
//            text="Career Options"
//        }
//        container.addView(career_options)
//
//        for(i in 0 until career_list.size)
//        {
//            var listitem=TextView(this).apply{
//                text=career_list[i]
//            }
//            container.addView(listitem)
//        }
//
//        var resources=TextView(this).apply{
//            text="Resources"
//        }
//        container.addView(resources)
//
//        for(i in 0 until resources_list.size)
//        {
//            var uri=resources_list[i].second
//            var listitem=TextView(this).apply{
//                text="${resources_list[i].first}->${resources_list[i].second}"
//                linksClickable=true
//                setOnClickListener {
//                   var inte= Intent(Intent.ACTION_VIEW, Uri.parse(uri))
//                    startActivity(inte)
//                }
//            }
//            container.addView(listitem)
//        }
//
//
//    }
//}

//
package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class career_and_resources_activity : AppCompatActivity() {

    // Career Lists
    private val mathsCareer = listOf(
        "Data Analyst", "Actuary", "Software Developer", "Statistician",
        "Mathematician"
    )
    private val scienceCareer = listOf(
        "Doctor", "Pharmacist", "Researcher", "Biotechnologist",
        "Astronomer"
    )
    private val artsCareer = listOf(
        "Writer", "Painter", "Designer", "Musician",
        "Actor"
    )
    private val commerceCareer = listOf(
        "Accountant", "Investment Banker", "Auditor", "Entrepreneur",
        "Business Analyst"
    )

    private val mathsHindiCareer = listOf(
        "डेटा विश्लेषक", "एक्चुअरी", "सॉफ़्टवेयर डेवलपर", "सांख्यिकीविद्",
        "गणितज्ञ"
    )
    private val scienceHindiCareer = listOf(
        "डॉक्टर", "फार्मासिस्ट", "शोधकर्ता", "जैव प्रौद्योगिकीविद्",
        "खगोलशास्त्री"
    )
    private val artsHindiCareer = listOf(
        "लेखक", "चित्रकार", "डिज़ाइनर", "संगीतकार",
        "अभिनेता"
    )
    private val commerceHindiCareer = listOf(
        "लेखाकार", "निवेश बैंकर", "लेखा परीक्षक", "उद्यमी",
        "व्यवसाय विश्लेषक"
    )

    // Resources
    private val mathsResources = listOf(
        "Khan Academy" to "https://www.khanacademy.org/math",
        "Brilliant.org" to "https://brilliant.org/",
        "Coursera Math" to "https://www.coursera.org/browse/math-and-logic",
        "MIT OpenCourseWare - Math" to "https://ocw.mit.edu/courses/mathematics/",
        "PatrickJMT" to "https://www.youtube.com/user/patrickJMT"
    )
    private val scienceResources = listOf(
        "MIT OpenCourseWare" to "https://ocw.mit.edu/",
        "Coursera Science" to "https://www.coursera.org/browse/physical-science-and-engineering",
        "National Geographic" to "https://www.nationalgeographic.com/science",
        "Khan Academy Science" to "https://www.khanacademy.org/science",
        "NASA Science" to "https://science.nasa.gov/"
    )
    private val artsResources = listOf(
        "Skillshare" to "https://www.skillshare.com/browse/art",
        "Udemy Arts" to "https://www.udemy.com/courses/design/",
        "Tate Kids" to "https://www.tate.org.uk/kids",
        "Drawspace" to "https://www.drawspace.com/",
        "MoMA Learning" to "https://www.moma.org/learn/moma_learning/"
    )
    private val commerceResources = listOf(
        "edX Business" to "https://www.edx.org/learn/business",
        "Coursera Finance" to "https://www.coursera.org/browse/business/finance",
        "Harvard Business School Online" to "https://online.hbs.edu/",
        "Investopedia" to "https://www.investopedia.com/",
        "Khan Academy Economics" to "https://www.khanacademy.org/economics-finance-domain"
    )

    private val mathsHindiResources = listOf(
        "PVRstudy प्रयागराज" to "https://www.youtube.com/watch?v=CVomAoyHnB4",
        "Easy Math With Minahil Khan" to "https://www.youtube.com/c/Minahilkhan",
        "Mathematics for Data Science and Machine Learning" to "https://www.youtube.com/watch?v=yDzJ4tgaN7A",
        "गणित by Vedantu" to "https://www.youtube.com/c/VedantuMath",
        "Magical Mathematics India" to "https://www.youtube.com/c/MagicalMathematicsIndia"
    )
    private val scienceHindiResources = listOf(
        "Vigyan TV India" to "https://www.youtube.com/c/VigyanTvIndia",
        "GetFlyScience" to "https://www.youtube.com/c/GetFlyScience",
        "Science Wale" to "https://www.youtube.com/c/ScienceWale",
        "Vedantu Science" to "https://www.youtube.com/c/VedantuScience",
        "Exergic Science" to "https://www.youtube.com/c/ExergicScience"
    )
    private val artsHindiResources = listOf(
        "Artist Reyanshh Rahul" to "https://www.youtube.com/@reyanshh_rahul",
        "Indian Artist" to "https://www.youtube.com/c/IndianArtistYouTube",
        "Nisha's Art Classes India" to "https://www.youtube.com/channel/UCOzHjGQAEXYbGxh2E6U0ebQ",
        "Art & Craft by Priya" to "https://www.youtube.com/c/PriyaArtCraft",
        "Creative Arts Hindi" to "https://www.youtube.com/c/CreativeArtsHindi"
    )
    private val commerceHindiResources = listOf(
        "Commerce Wale Guruji" to "https://www.youtube.com/c/CommerceWaleGuruJi",
        "Study with Sudhir" to "https://www.youtube.com/c/StudyWithSudhir",
        "CA Rachana Phadke Ranade" to "https://www.youtube.com/c/CARachanaPhadkeRanade",
        "Commerce Baba" to "https://www.youtube.com/c/CommerceBaba",
        "Accounts Guruji" to "https://www.youtube.com/c/AccountsGuruji"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_career_and_resources)

        val container = findViewById<LinearLayout>(R.id.container)
        ViewCompat.setOnApplyWindowInsetsListener(container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val language = intent.getStringExtra("language_selected") ?: ""

        // Select career and resource list
        val careerList = when (language) {
            "maths" -> mathsCareer
            "science" -> scienceCareer
            "arts" -> artsCareer
            "commerce" -> commerceCareer
            "गणित" -> mathsHindiCareer
            "विज्ञान" -> scienceHindiCareer
            "कला" -> artsHindiCareer
            "वाणिज्य" -> commerceHindiCareer
            else -> emptyList()
        }

        val resourceList = when (language) {
            "maths" -> mathsResources
            "science" -> scienceResources
            "arts" -> artsResources
            "commerce" -> commerceResources
            "गणित" -> mathsHindiResources
            "विज्ञान" -> scienceHindiResources
            "कला" -> artsHindiResources
            "वाणिज्य" -> commerceHindiResources
            else -> emptyList()
        }

//        // --- Domain Header ---
//        container.addView(createHeader(language))
//
//        // --- Career Section ---
//        container.addView(createHeader("Career Options"))
//        careerList.forEach { career ->
//            container.addView(createCardItem(career))
//        }
//         // Divider
//        container.addView(createDivider())
//        // --- Resources Section ---
//        container.addView(createHeader("Resources"))
//        resourceList.forEach { (name, url) ->
//            container.addView(createCardLinkItem(name, url))
//        }
//    }
//
//    private fun createHeader(title: String): TextView {
//        return TextView(this).apply {
//            text = title
//            textSize = 22f
//            setPadding(16, 24, 16, 8)
//            setTypeface(null, android.graphics.Typeface.BOLD)
//        }
//    }
//
//    private fun createCardItem(text: String): CardView {
//        val card = CardView(this)
//        card.setContentPadding(16, 16, 16, 16)
//        card.useCompatPadding = true
//        card.radius = 12f
//        card.cardElevation = 6f
//
//        val tv = TextView(this)
//        tv.text = "• $text"
//        tv.textSize = 16f
//        card.addView(tv)
//        return card
//    }
//
//    private fun createCardLinkItem(name: String, url: String): CardView {
//        val card = CardView(this)
//        card.setContentPadding(16, 16, 16, 16)
//        card.useCompatPadding = true
//        card.radius = 12f
//        card.cardElevation = 6f
//
//        val tv = TextView(this)
//        tv.text = name
//        tv.textSize = 16f
//        tv.setTextColor(resources.getColor(android.R.color.holo_blue_dark, theme))
//        tv.setOnClickListener {
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
//        }
//
//        card.addView(tv)
//        return card
//    }
//}
//
//
//
//    private fun createDivider(): TextView {
//        return TextView(this).apply {
//            layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT, 2
//            ).apply { setMargins(16, 16, 16, 16) }
//            setBackgroundColor(resources.getColor(android.R.color.darker_gray, theme))
//        }
//    }
        var head = when (language) {
            "maths" -> "MATHS"
            "science" -> "SCIENCE"
            "arts" -> "ARTS"
            "commerce" -> "COMMERCE"
            "गणित" -> "गणित"
            "विज्ञान" -> "विज्ञान"
            "कला" -> "कला"
            "वाणिज्य" -> "वाणिज्य"
            else -> " "
        }

        // Domain Header
        container.addView(createHeader(head))

        // Career Section
        container.addView(createHeader("Career Options"))
        careerList.forEach { career ->
            container.addView(createCardItem(career, section = "career"))
        }

        // Divider
        container.addView(createDivider())

        // Resources Section
        container.addView(createHeader("Resources"))
        resourceList.forEach { (name, url) ->
            container.addView(createCardItem(name, url, section = "resource"))

        }
    }

    private fun createHeader(title: String): TextView {
        return TextView(this).apply {
            text = title
            textSize = 22f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(24, 24, 24, 16)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = android.view.Gravity.CENTER_HORIZONTAL
            }
        }
    }

    private fun createCardItem(
        text: String,
        url: String? = null,
        section: String = "career"
    ): CardView {
        val card = CardView(this)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(24, 12, 24, 12)
        card.layoutParams = params

        card.radius = 16f
        card.cardElevation = 8f
        card.useCompatPadding = true

        card.setCardBackgroundColor(
            resources.getColor(
                if (section == "career") android.R.color.holo_orange_light
                else android.R.color.holo_blue_light,
                theme
            )
        )

        val tv = TextView(this)
        tv.text = if (url != null) text else "• $text"
        tv.textSize = 18f
        tv.setPadding(16, 16, 16, 16)
        if (section == "career") {
            // Black text for orange background
            tv.setTextColor(resources.getColor(android.R.color.black, theme))
        } else {
            // White text for blue background (resources)
            tv.setTextColor(Color.WHITE)
        }
        if (url != null) {
            tv.setTextColor(Color.WHITE)
            tv.setOnClickListener {
                startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage(
                        "com.example.quiz_app"
                    )
                )
            }
        }
        card.addView(tv)
        return card
    }


    private fun createDivider(): TextView {
        return TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 2
            ).apply { setMargins(24, 16, 24, 16) }
            setBackgroundColor(resources.getColor(android.R.color.darker_gray, theme))
        }
    }
}


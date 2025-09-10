package com.example.quiz_app

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class Data_from_json(context: Context) {

    val inputStream=context.resources.openRawResource(R.raw.questions);
    val jsonStr = inputStream.bufferedReader().use { it.readText() }
    val jsonarr= JSONArray(jsonStr);
    val math_domainlist= ArrayList<struct>();
    val science_domainlist= ArrayList<struct>();
    val arts_domainlist= ArrayList<struct>();
    val commerce_domainlist= ArrayList<struct>();
    val math_hindi_list= ArrayList<struct>();
    val science_hindi_list= ArrayList<struct>();
    val arts_hindi_list= ArrayList<struct>();
    val commerce_hindi_list= ArrayList<struct>();


    init {

        for (i in 0 until jsonarr.length())
        {
            var obj=jsonarr.getJSONObject(i)
            var options=obj.getJSONArray("options");
            var options_of_arr= ArrayList<String>();
            for(j in 0 until options.length())
            {
                options_of_arr.add(options.getString(j));
            }
            if(obj.getString("domain").equals("Mathematics"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                math_domainlist.add(structure);
            }
            else if(obj.getString("domain").equals("Science"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                science_domainlist.add(structure);
            }
            else if(obj.getString("domain").equals("Arts"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                arts_domainlist.add(structure);
            }
            else if(obj.getString("domain").equals("Commerce"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                commerce_domainlist.add(structure);
            }
            else if(obj.getString("domain").equals("गणित"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                math_hindi_list.add(structure);
            }
            else if(obj.getString("domain").equals("विज्ञान"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                science_hindi_list.add(structure);
            }
            else if(obj.getString("domain").equals("कला"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                arts_hindi_list.add(structure);
            }
            else if(obj.getString("domain").equals("वाणिज्य"))
            {
                var structure= struct(obj.getString("question"),options_of_arr,obj.getString("answer"));
                commerce_hindi_list.add(structure);
            }
        }

    }

}
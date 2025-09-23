package com.example.quiz_app
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar

import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Runnable


@SuppressLint("SuspiciousIndentation")
class structure_of_recycler_view(var cont: Context, val arr: ArrayList<struct>,var curr:Int,var question_no: TextView,var seek_b: SeekBar,var progress:TextView,
    var correct:Int,var wrong: Int,var lan:Int,var language_selected:String?): RecyclerView.Adapter<structure_of_recycler_view.ViewHolder>() {
    val filtered_List = ArrayList<struct>(arr);
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val a = LayoutInflater.from(cont).inflate(R.layout.activity_mcq_structure, parent, false);
        return ViewHolder(a)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.option_1.setBackgroundColor(Color.WHITE)
            holder.option_2.setBackgroundColor(Color.WHITE)
            holder.option_3.setBackgroundColor(Color.WHITE)
            holder.option_4.setBackgroundColor(Color.WHITE)
            enable(holder.option_1,holder.option_2,holder.option_3,holder.option_4)
            holder.txt.setText(filtered_List[position].question);
            holder.option_1.setText(filtered_List[position].options[0]);
            holder.option_2.setText(filtered_List[position].options[1]);
            holder.option_3.setText(filtered_List[position].options[2]);
            holder.option_4.setText(filtered_List[position].options[3]);
              holder.option_1.setOnClickListener {
               perform(holder.option_1,position)
               disable(holder.option_1,holder.option_2,holder.option_3,holder.option_4)
          }
              holder.option_2.setOnClickListener {
            perform(holder.option_2,position)
            disable(holder.option_1,holder.option_2,holder.option_3,holder.option_4)
        }
              holder.option_3.setOnClickListener {
            perform(holder.option_3,position)
            disable(holder.option_1,holder.option_2,holder.option_3,holder.option_4)
        }
              holder.option_4.setOnClickListener {
            perform(holder.option_4,position)
            disable(holder.option_1,holder.option_2,holder.option_3,holder.option_4)
        }
    }

    override fun getItemCount(): Int {
        return filtered_List.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<TextView>(R.id.question);
        var option_1 = itemView.findViewById<Button>(R.id.option_1);
        var option_2 = itemView.findViewById<Button>(R.id.option_2);
        var option_3 = itemView.findViewById<Button>(R.id.option_3);
        var option_4 = itemView.findViewById<Button>(R.id.option_4);
    }
    fun filter() {
        filtered_List.clear();
        filtered_List.add(arr[curr]);
        notifyDataSetChanged()
    }
    fun enable(bt1: Button,bt2: Button,bt3: Button,bt4: Button)
    {
        bt1.isEnabled=true
        bt2.isEnabled=true
        bt3.isEnabled=true
        bt4.isEnabled=true
    }
    fun disable(bt1: Button,bt2: Button,bt3: Button,bt4: Button)
    {
        bt1.isEnabled=false
        bt2.isEnabled=false
        bt3.isEnabled=false
        bt4.isEnabled=false
    }
    fun perform(bt1:Button,position: Int)
    {
        if((curr+1)<10) {
            curr=curr+1
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                question_no.setText("Question ${curr+1} of 10")
                seek_b.progress=curr+1
                var maxProgress=seek_b.max
                var percentage=((seek_b.progress.toFloat() / maxProgress) * 100).toInt()
                progress.setText("${percentage}%")
                filter()
            },1000)
        }
        else
        {
            if(bt1.text==filtered_List[position].answer )
            {
                bt1.setBackgroundColor(Color.GREEN)
                correct++
            }
            else
            {
                bt1.setBackgroundColor(Color.RED)
                wrong++
            }
            var intent= Intent(cont, User_Progress::class.java)

            intent.putExtra("Correct",correct)
            intent.putExtra("Wrong",wrong)
            intent.putExtra("lang",lan)
            intent.putExtra("language_selected",language_selected)
            cont.startActivity(intent)
        }
        if(bt1.text==filtered_List[position].answer )
        {
            bt1.setBackgroundColor(Color.GREEN)
            correct++
        }
        else
        {
            bt1.setBackgroundColor(Color.RED)
            wrong++
        }
    }


}

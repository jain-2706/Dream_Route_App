package com.example.quiz_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollegeAdapter(private val collegeList: List<School>) :
    RecyclerView.Adapter<CollegeAdapter.CollegeViewHolder>() {

    class CollegeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val collegeName: TextView = itemView.findViewById(R.id.tvCollegeName)
        val cityState: TextView = itemView.findViewById(R.id.tvCityState)
        val studentSize: TextView = itemView.findViewById(R.id.tvStudentSize)
        val academicCost: TextView = itemView.findViewById(R.id.tvAcademicCost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemcollege, parent, false)
        return CollegeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        val college = collegeList[position]
        holder.collegeName.text = college.name?: "N/A"
        holder.cityState.text = "${college.city ?: "N/A"}, ${college.state?: "N/A"}"
        holder.studentSize.text = "Students: ${college.studentSize?.toString() ?: "N/A"}"
        holder.academicCost.text =
            "Academic Cost: ${college.academicCost ?: "N/A"}"
    }

    override fun getItemCount(): Int = collegeList.size
}

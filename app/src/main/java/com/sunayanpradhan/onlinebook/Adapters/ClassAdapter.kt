package com.sunayanpradhan.onlinebook.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunayanpradhan.onlinebook.Activities.SubjectActivity
import com.sunayanpradhan.onlinebook.Models.ClassModel
import com.sunayanpradhan.onlinebook.R

class ClassAdapter(private val list: ArrayList<ClassModel>, private val context: Context):RecyclerView.Adapter<ClassAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val classImage:ImageView= itemView.findViewById(R.id.topic_image)

        val classText:TextView= itemView.findViewById(R.id.topic_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topic_layout,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list[position]

        Glide.with(context.applicationContext)
            .load(currentItem.classLogo)
            .into(holder.classImage)

        holder.classText.text=currentItem.className

        holder.itemView.setOnClickListener {

            val intent= Intent(context,SubjectActivity::class.java)

            intent.putExtra("classId",currentItem.classId)

            intent.putExtra("className",currentItem.className)

            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


}
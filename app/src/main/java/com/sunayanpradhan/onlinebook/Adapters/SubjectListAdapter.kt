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
import com.sunayanpradhan.onlinebook.Activities.TopicActivity
import com.sunayanpradhan.onlinebook.Models.SubjectModel
import com.sunayanpradhan.onlinebook.R

class SubjectListAdapter(private val list: ArrayList<SubjectModel>, private val context: Context):RecyclerView.Adapter<SubjectListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val listImage:ImageView= itemView.findViewById(R.id.list_image)

        val listText:TextView= itemView.findViewById(R.id.list_text)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = list[position]

        Glide.with(context.applicationContext)
            .load(currentItem.subjectLogo)
            .into(holder.listImage)

        holder.listText.text=currentItem.subjectName

        holder.itemView.setOnClickListener {

            val intent= Intent(context,TopicActivity::class.java)

            intent.putExtra("subjectId",currentItem.subjectId)

            intent.putExtra("classId",currentItem.classId)

            intent.putExtra("subjectName",currentItem.subjectName)

            context.startActivity(intent)


        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


}
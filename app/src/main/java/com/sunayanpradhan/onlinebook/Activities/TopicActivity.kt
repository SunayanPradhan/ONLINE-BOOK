package com.sunayanpradhan.onlinebook.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.onlinebook.Adapters.TopicListAdapter
import com.sunayanpradhan.onlinebook.Models.BookModel
import com.sunayanpradhan.onlinebook.R
import com.sunayanpradhan.onlinebook.databinding.ActivityTopicBinding

class TopicActivity : AppCompatActivity() {

    lateinit var binding: ActivityTopicBinding

    lateinit var list: ArrayList<BookModel>

    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_topic)

        firebaseDatabase=FirebaseDatabase.getInstance()

        list= ArrayList()

        val subjectId=intent.getIntExtra("subjectId",0)

        val classId=intent.getIntExtra("classId",0)

        val subjectName=intent.getStringExtra("subjectName")

        binding.optionsTitle.text=subjectName

        var adapter=TopicListAdapter(list,this)

        val layoutManager=LinearLayoutManager(this)

        binding.topicRv.layoutManager=layoutManager

        firebaseDatabase.reference.child("Topics")
            .addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    list.clear()

                    if (snapshot.exists()){

                        for (dataSnapshot in snapshot.children){

                            var data=dataSnapshot.getValue(BookModel::class.java)

                            data?.topicId= dataSnapshot.key?.toInt()!!

                            if (data?.subjectId==subjectId && data.classId==classId){

                                list.add(data)

                            }

                        }

                        adapter.notifyDataSetChanged()

                        binding.topicRv.adapter=adapter

                    }


                }

                override fun onCancelled(error: DatabaseError) {


                }

            })



    }
}
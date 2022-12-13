package com.sunayanpradhan.onlinebook.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sunayanpradhan.onlinebook.Adapters.ClassAdapter
import com.sunayanpradhan.onlinebook.Adapters.TopicListAdapter
import com.sunayanpradhan.onlinebook.Models.ClassModel
import com.sunayanpradhan.onlinebook.R
import com.sunayanpradhan.onlinebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var list: ArrayList<ClassModel>

    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        firebaseDatabase= FirebaseDatabase.getInstance()

        list= ArrayList()

        var adapter=ClassAdapter(list,this)

        val layoutManager= GridLayoutManager(this,2)

        binding.classRv.layoutManager=layoutManager

        firebaseDatabase.reference.child("Classes")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    list.clear()

                    if (snapshot.exists()){

                        for (dataSnapshot in snapshot.children){

                            val data = dataSnapshot.getValue(ClassModel::class.java)

                            data?.classId= dataSnapshot.key?.toInt()!!

                            list.add(data!!)

                        }

                        adapter.notifyDataSetChanged()

                        binding.classRv.adapter=adapter


                    }


                }

                override fun onCancelled(error: DatabaseError) {



                }

            })



    }
}
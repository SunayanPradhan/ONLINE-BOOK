package com.sunayanpradhan.onlinebook.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sunayanpradhan.onlinebook.R
import com.sunayanpradhan.onlinebook.Utils.PdfDownload
import com.sunayanpradhan.onlinebook.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

    companion object {

        lateinit var binding: ActivityContentBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_content)

        val topicPdf=intent.getStringExtra("topicPdf")

        val topicName=intent.getStringExtra("topicName")

        binding.optionsTitle.text=topicName

        PdfDownload().execute(topicPdf)

    }
}
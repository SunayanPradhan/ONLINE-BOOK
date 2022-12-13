package com.sunayanpradhan.onlinebook.Utils

import android.os.AsyncTask
import android.view.View
import com.sunayanpradhan.onlinebook.Activities.ContentActivity.Companion.binding
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class PdfDownload :AsyncTask<String,Void,InputStream>() {

    override fun doInBackground(vararg p0: String?): InputStream {
        var inputStream: InputStream? = null

        binding.progressBar.visibility= View.VISIBLE

        try {
            val url= URL(p0[0])
            val urlConnection: HttpURLConnection =url.openConnection() as HttpURLConnection
            if(urlConnection.responseCode==200){
                inputStream= BufferedInputStream(urlConnection.inputStream)
            }

        }catch (e:Exception){
            e.printStackTrace()
        }

        return inputStream!!
    }

    override fun onPostExecute(result: InputStream?) {

       binding.contentPdf.fromStream(result).load().let{

           binding.progressBar.visibility= View.GONE

       }
    }



}


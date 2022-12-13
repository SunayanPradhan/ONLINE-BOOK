package com.sunayanpradhan.onlinebook.Models

data class BookModel(var topicId:Int,
                     var topicName:String,
                     var topicPdf:String,
                     var topicLogo:String,
                     var subjectId:Int,
                     var classId:Int)
{
    constructor():this(
        0,
        "",
        "",
        "",
        0,
        0
    )

}

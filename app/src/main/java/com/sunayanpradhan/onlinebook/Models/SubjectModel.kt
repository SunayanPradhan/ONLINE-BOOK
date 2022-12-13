package com.sunayanpradhan.onlinebook.Models

data class SubjectModel(var subjectId:Int,
                        var subjectName:String,
                        var subjectLogo:String,
                        var classId:Int)
{
    constructor():this(
        0,
        "",
        "",
        0
    )
}
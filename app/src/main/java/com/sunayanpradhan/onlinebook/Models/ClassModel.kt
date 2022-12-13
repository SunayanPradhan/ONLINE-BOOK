package com.sunayanpradhan.onlinebook.Models

data class ClassModel(var classId:Int,
                      var className:String,
                      var classLogo:String)
{
    constructor():this(
        0,
        "",
        ""
    )
}

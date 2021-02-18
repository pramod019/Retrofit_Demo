package com.pramodk.myapp2.model

import retrofit2.Response

data class Post(
    val userId:Int,
    val id: Int,
    val title: String,
    val body: String
)

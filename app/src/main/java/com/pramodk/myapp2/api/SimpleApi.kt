package com.pramodk.myapp2.api

import com.pramodk.myapp2.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//https://jsonplaceholder.typicode.com/posts
interface SimpleApi {
    @GET("/posts")
    suspend fun getPosts():Response<List<Post>>

}
package com.pramodk.myapp2.api

import com.pramodk.myapp2.model.Post
import retrofit2.Response
import retrofit2.http.GET
//https://jsonplaceholder.typicode.com/posts
interface SimpleApi {
    @GET("/posts/1")
    suspend fun getPosts():Response<Post>
}
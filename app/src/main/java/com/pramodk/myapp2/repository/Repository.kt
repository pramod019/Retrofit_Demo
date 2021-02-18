package com.pramodk.myapp2.repository

import com.pramodk.myapp2.api.RetrofitInstance
import com.pramodk.myapp2.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost():Response<Post>{
        return RetrofitInstance.api.getPosts()
    }
}
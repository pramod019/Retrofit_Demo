package com.pramodk.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.pramodk.myapp2.repository.Repository
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()

        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("mainACTIVITY", response.body()?.id.toString())
                Log.d("mainACTIVITY", response.body()?.userId.toString())
                Log.d("mainACTIVITY", response.body()?.title!!)
                Log.d("mainACTIVITY", response.body()?.body!!)
                //textView.text = response.body()?.title!!
            } else{
                Log.d("mainACTIVITY", response.errorBody().toString())
            }
        }
        )
    }
}
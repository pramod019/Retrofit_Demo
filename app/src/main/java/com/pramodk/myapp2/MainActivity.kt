package com.pramodk.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pramodk.myapp2.adapter.MyAdapter
import com.pramodk.myapp2.repository.Repository

class MainActivity : AppCompatActivity() {

    //instance for viewModel
    private lateinit var viewModel: MainViewModel

    //instance for adapter
    private val myAdapter by lazy { MyAdapter() }

    //recyclerview
    private lateinit var recyclerview :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //repository object/instance
        val repository = Repository()

        //initializing recyclerView
        setUpRecyclerView()

        //viewModelFactory object/instance
        val viewModelFactory = MainViewModelFactory(repository)

        //initializing ViewModel
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        //fetching getPost function from viewModel
        viewModel.getPost()

        //observing the result in recyclerview
        viewModel.myResponse.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let { myAdapter.setData(it) }
            } else{
                Log.d("mainACTIVITY", response.errorBody().toString())
            }
        }
        )
    }
    private fun setUpRecyclerView(){
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.adapter = myAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
package com.pramodk.myapp2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pramodk.myapp2.repository.Repository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}
package com.pramodk.myapp2
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.pramodk.myapp2.model.Post
import com.pramodk.myapp2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    //val myResponse = MutableLiveData<Response<Post>>()
    var myResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

   fun getPost(){
       viewModelScope.launch {
           val response = repository.getPost()
           myResponse.value = response
       }
   }


}
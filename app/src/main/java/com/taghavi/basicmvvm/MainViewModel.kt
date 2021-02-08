package com.taghavi.basicmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(), CoroutineScope by MainScope() {
    companion object {
        const val LOG = "GetDogLog"
    }

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun getRandomDog() {
        launch(Dispatchers.Main) {
            try {
                val response = ServiceBuilder.apiService.getRandomDog()
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.message?.let {
                        _message.value = it
                        Log.d(LOG, it)
                    }
                } else {
                    Log.d(LOG, "Server error")
                }
            } catch (exception: Exception) {
                exception.message?.let {
                    Log.d(LOG, it)
                }
            }
        }
    }
}
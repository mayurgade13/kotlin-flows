package com.example.kotlin_flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            getUsers().forEach {
                Log.d("####", "name is  - $it")
            }
        }
    }

    private suspend fun getUsers(): List<String> {
        val list : MutableList<String> =  mutableListOf()
        list.add(fetchUser(1))
        list.add(fetchUser(2))
        list.add(fetchUser(3))
        return list
    }

    private suspend fun fetchUser(id: Int): String {
        delay(1000) // API call
        return "user$id"
    }
}

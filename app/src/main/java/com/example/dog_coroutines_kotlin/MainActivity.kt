package com.example.dog_coroutines_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.example.dog_coroutines_kotlin.network.TheAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
/*Created by qen dev
* on 28-10-20*/

//Coroutines is an asynchronous utility in Kotlin that allows you to perform multithreading tasks easily.
//In order to call a Coroutine, we have to implement a CoroutineScope.
//This provides the scope in which the given coroutine should send out its results
//In our case, we will implement the MainScope(), which creates the scope for UI components.

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonGetImage.setOnClickListener {
            // Use launch and pass Dispatchers.Main to tell that
            // the result of this Coroutine is expected on the main thread.
            launch(Dispatchers.Main) {
                // Try catch block to handle exceptions when calling the API.
                try {
                    val response = TheAdapter.dogClient.getDog()
                    Log.e("XXXX", response.body().toString())

                    // Check if response was successful.
                    if (response.isSuccessful && response.body() != null) {

                        val data = response.body()!!
                        Log.e("XXX", data.toString())

                        // Check for null
                        data.message?.let { imageUrl ->
                            // Load URL into the ImageView using Coil.
                            Log.e("XXX","No Image")

                            imageviewDogImage.load(imageUrl)
                        }
                    } else {
                        // Show API error.
                        Log.e("Error Tracking", response.code().toString())

                        Toast.makeText(
                            this@MainActivity,
                            "Error Occurred: ${response.message()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } catch (e: Exception) {
                    // Show API error. This is the error raised by the client.
                    Log.e("XXX","Not Going thru")
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }


}

package com.example.dog_coroutines_kotlin.network

import com.example.dog_coroutines_kotlin.DogClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/*Created by qendev
* on 28-10-20*/

/*This file will hold the instance of the Retrofit client.
 Invoking the Retrofit builder, we pass in the base URL an OkHttpClient instance as our HTTP client,
 and a GsonConverterFactory which will do the JSON-Object conversion for us. */
object TheAdapter {
    val dogClient:DogClient =Retrofit.Builder()
        .baseUrl("https://dog.ceo/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogClient::class.java)




}
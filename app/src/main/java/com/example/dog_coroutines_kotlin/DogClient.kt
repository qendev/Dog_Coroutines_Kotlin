package com.example.dog_coroutines_kotlin

import com.example.dog_coroutines_kotlin.models.ImageModel
import retrofit2.Response
import retrofit2.http.GET

/*Created by qendev
* on 28-10-20*/
interface DogClient {

    @GET("\"/api/breeds/image/random\"")
    suspend fun getDog(): Response<ImageModel>
}
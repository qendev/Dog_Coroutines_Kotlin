package com.example.dog_coroutines_kotlin.models

import androidx.annotation.Keep

/*Created by qendev
* on 28-10-20*/

//The @Keep annotation is to ensure the class is not obfuscated when using Proguard, which would cause a crash otherwise.
@Keep
class ImageModel {
    var message: String? = null
    var status: String? = null
}
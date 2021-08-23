package org.devdias.apifromnasa.api

import org.devdias.apifromnasa.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Retrofit instance class (builder)
 **/

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val createConnection: RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java)
    }
}
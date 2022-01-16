package com.yongjincompany.norasinchungsu.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {

    val api: SongApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.220.158.125:4000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SongApi::class.java)
    }
}
package com.yongjincompany.norasinchungsu.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface SongApi {
    @GET("/song")
    suspend fun getTodos(): Response<List<SongApi>>
}
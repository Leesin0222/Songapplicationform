package com.yongjincompany.songapplicationform.data.api

import android.widget.EditText
import com.yongjincompany.songapplicationform.data.RecieveSongResponseDTO
import com.yongjincompany.songapplicationform.data.SendSongRequestDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface SongApi {

    @POST("/song")
    fun postSong(
        @Body sendSong: String
    ): Call<SendSongRequestDTO>

    @GET("/song")
    fun getSongList() : Call<List<RecieveSongResponseDTO>>

    @DELETE("/song/{id}")
    suspend fun deleteSong(
        @Path ("id") id: Int
    )
}
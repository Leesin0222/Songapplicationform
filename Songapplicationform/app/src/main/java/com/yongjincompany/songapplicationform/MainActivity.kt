package com.yongjincompany.songapplicationform

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dialog_view.*
import kotlinx.android.synthetic.main.dialog_view.view.*
import com.yongjincompany.songapplicationform.data.RecieveSongResponseDTO
import com.yongjincompany.songapplicationform.data.api.ApiProvider
import com.yongjincompany.songapplicationform.data.api.SongApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiProvider.service.getSongList().enqueue(object : Callback<List<RecieveSongResponseDTO>> {
            override fun onResponse(
                call: Call<List<RecieveSongResponseDTO>>,
                response: Response<List<RecieveSongResponseDTO>>
            ) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<RecieveSongResponseDTO>>, t: Throwable) {
                d("daniel", "onFailure")
            }

        })



        godialogbtn.setOnClickListener {
            val view = View.inflate(this, R.layout.dialog_view, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)


            view.applicatebtn.setOnClickListener {


            }
        }
    }

    private fun showData(songs: List<RecieveSongResponseDTO>) {
        applicatelist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = SongAdapter(songs)
        }
    }

}
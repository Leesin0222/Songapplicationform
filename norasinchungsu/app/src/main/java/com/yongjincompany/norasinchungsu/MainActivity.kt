package com.yongjincompany.norasinchungsu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yongjincompany.norasinchungsu.data.remote.api.ApiInstance
import com.yongjincompany.norasinchungsu.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var songAdapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                ApiInstance.api.getSongs()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, 인터넷문제")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, 응답이 어디감?")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                songAdapter.songs = response.body()!!
            } else {
                Log.e(TAG, "Responce (응답)가(이) 실패했다")
            }
            binding.progressBar.isVisible = false
        }


    }

    private fun setupRecyclerView() = binding.applicatelist.apply {
        songAdapter = SongAdapter()
        adapter = songAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}
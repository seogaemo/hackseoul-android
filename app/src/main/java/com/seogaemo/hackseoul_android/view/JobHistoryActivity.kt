package com.seogaemo.hackseoul_android.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.seogaemo.hackseoul_android.data.PipLineBody
import com.seogaemo.hackseoul_android.data.ProductResponse
import com.seogaemo.hackseoul_android.database.SharedPreference
import com.seogaemo.hackseoul_android.databinding.ActivityJobHistoryBinding
import com.seogaemo.hackseoul_android.network.RetrofitAPI
import com.seogaemo.hackseoul_android.network.RetrofitClient
import com.seogaemo.hackseoul_android.util.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JobHistoryActivity : BaseActivity() {
    private lateinit var binding: ActivityJobHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id").toString()

        lifecycleScope.launch {
            getProduct(this@JobHistoryActivity, id)?.let {
                binding.titleText.text = it.title
                Glide.with(this@JobHistoryActivity)
                    .load(it.imageUrl)
                    .centerCrop()
                    .into(binding.itemImageView)
            }

            binding.backButton.setOnClickListener {
                finish()
            }

            binding.submitButton.setOnClickListener {
            }
        }
    }

    private suspend fun postPipeline(body: PipLineBody): Void? {
        return try {
            withContext(Dispatchers.IO) {
                val retrofitAPI = RetrofitClient.getInstance().create(RetrofitAPI::class.java)
                val response = retrofitAPI.postPipeline(body)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    withContext(Dispatchers.Main) {
                    }
                    null
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
            }
            null
        }
    }


    private suspend fun getProduct(context: Context, id: String): ProductResponse? {
        return try {
            withContext(Dispatchers.IO) {
                val retrofitAPI = RetrofitClient.getInstance().create(RetrofitAPI::class.java)
                val response = retrofitAPI.getProduct("bearer ${SharedPreference.token}", id)
                if (response.isSuccessful) {
                    response.body()
                } else {

                    null
                }
            }
        } catch (e: Exception) {

            null
        }
    }

}
package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seogaemo.hackseoul_android.databinding.ActivityJobHistoryBinding

class JobHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
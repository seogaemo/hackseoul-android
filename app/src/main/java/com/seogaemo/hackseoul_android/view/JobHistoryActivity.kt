package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import com.seogaemo.hackseoul_android.databinding.ActivityJobHistoryBinding
import com.seogaemo.hackseoul_android.util.BaseActivity

class JobHistoryActivity : BaseActivity() {
    private lateinit var binding: ActivityJobHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
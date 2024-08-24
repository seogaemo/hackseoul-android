package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seogaemo.hackseoul_android.databinding.ActivityDistributionBinding

class DistributionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDistributionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistributionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seogaemo.hackseoul_android.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
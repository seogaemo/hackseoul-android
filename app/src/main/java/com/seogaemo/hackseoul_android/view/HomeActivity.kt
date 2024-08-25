package com.seogaemo.hackseoul_android.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.seogaemo.hackseoul_android.R
import com.seogaemo.hackseoul_android.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
        }

        binding.qrButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        }
    }
}
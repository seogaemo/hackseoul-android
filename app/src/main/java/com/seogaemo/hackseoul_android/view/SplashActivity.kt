package com.seogaemo.hackseoul_android.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.seogaemo.hackseoul_android.database.SharedPreference
import com.seogaemo.hackseoul_android.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handlingActivities()
    }

    private fun handlingActivities() {
        val action: String? = intent?.action
        val data: Uri? = intent?.data

        Handler(Looper.getMainLooper()).postDelayed({
            if (SharedPreference.isFirst) {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            } else {
                if (action == Intent.ACTION_VIEW) {
                    val id = data?.getQueryParameter("id")
                    val intent = Intent(this@SplashActivity, ProductActivity::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                } else {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                }
            }
            finishAffinity()
        }, 1500)
    }

}

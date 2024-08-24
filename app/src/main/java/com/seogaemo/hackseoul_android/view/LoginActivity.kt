package com.seogaemo.hackseoul_android.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.seogaemo.hackseoul_android.databinding.ActivityLoginBinding
import com.seogaemo.hackseoul_android.util.BaseActivity

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (binding.idInput.text.isNotEmpty() && binding.passwordInput.text.isNotEmpty()) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finishAffinity()
            } else {
                Toast.makeText(this@LoginActivity, "필수 입력 필드를 채워주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
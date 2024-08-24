package com.seogaemo.hackseoul_android.view

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.ImageView
import android.widget.Toast
import com.seogaemo.hackseoul_android.R
import com.seogaemo.hackseoul_android.databinding.ActivityLoginBinding
import com.seogaemo.hackseoul_android.util.BaseActivity

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var passwordToggle = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.passwordToggleButton.setOnClickListener {
            if (!passwordToggle) {
                (it as ImageView).setImageResource(R.drawable.password_hide_icon)
                binding.passwordInput.apply {
                    this.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    this.setSelection(this.text.length)
                }
            } else {
                (it as ImageView).setImageResource(R.drawable.password_show_icon)
                binding.passwordInput.apply {
                    this.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    this.setSelection(this.text.length)
                }
            }
            passwordToggle = !passwordToggle
        }

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
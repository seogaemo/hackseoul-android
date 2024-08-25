package com.seogaemo.hackseoul_android.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.seogaemo.hackseoul_android.R
import com.seogaemo.hackseoul_android.data.SignInRequest
import com.seogaemo.hackseoul_android.data.SignInResponse
import com.seogaemo.hackseoul_android.database.SharedPreference
import com.seogaemo.hackseoul_android.databinding.ActivityLoginBinding
import com.seogaemo.hackseoul_android.network.RetrofitAPI
import com.seogaemo.hackseoul_android.network.RetrofitClient
import com.seogaemo.hackseoul_android.util.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                lifecycleScope.launch {
                    val token = postSignIn(this@LoginActivity, SignInRequest(binding.idInput.text.toString(), binding.passwordInput.text.toString()))
                    if (token != null) {
                        SharedPreference.token = token.token
                        SharedPreference.isFirst = false

                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finishAffinity()
                    }
                }
            } else {
                Toast.makeText(this@LoginActivity, "필수 입력 필드를 채워주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun postSignIn(context: Context, signInRequest: SignInRequest): SignInResponse? {
        return try {
            withContext(Dispatchers.IO) {
                val retrofitAPI = RetrofitClient.getInstance().create(RetrofitAPI::class.java)
                val response = retrofitAPI.signIn(signInRequest)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show()
                    }
                    null
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "로그인에 실패하였습니다", Toast.LENGTH_SHORT).show()
            }
            null
        }
    }

}
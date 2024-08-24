package com.seogaemo.hackseoul_android.util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seogaemo.hackseoul_android.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.anim_slide_in_from_right_fade_in, R.anim.anim_fade_out)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.anim_slide_in_from_left_fade_in, R.anim.anim_fade_out)
    }

}

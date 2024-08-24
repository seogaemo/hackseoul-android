package com.seogaemo.hackseoul_android.view

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DefaultDecoderFactory
import com.seogaemo.hackseoul_android.R
import com.seogaemo.hackseoul_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWindowInsets()

        with(binding.barcodeScanner) {
            barcodeView.decoderFactory =
                DefaultDecoderFactory(arrayListOf(BarcodeFormat.QR_CODE, BarcodeFormat.EAN_13))
            barcodeView.cameraSettings.isAutoFocusEnabled = true
            decodeContinuous(callback)
        }
    }

    private val callback = BarcodeCallback { result: BarcodeResult? ->
        if (System.currentTimeMillis() - this.currentTime >= 3000) {
            result?.let { barcodeResult ->
                this.createRequest(barcodeResult.text)
            }
        }
        this.currentTime = System.currentTimeMillis()
    }

    private fun createRequest(qrCodeText: String) {
        if (qrCodeText.startsWith("http://") || qrCodeText.startsWith("https://")) {

        }
    }

    private fun setupWindowInsets() {
        enableEdgeToEdge()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
           window.apply {
                this.decorView.systemUiVisibility = this.decorView.systemUiVisibility and
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        binding.barcodeScanner.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.barcodeScanner.pause()
    }
}
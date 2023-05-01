package com.example.studenthelper

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.studenthelper.databinding.ActivityRaspBinding

class Rasp : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var binding: ActivityRaspBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rasp)
        binding = ActivityRaspBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        binding.rasp.webViewClient = WebViewClient()

        binding.rasp.apply {
            loadUrl("https://rasp.tpu.ru/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.domStorageEnabled = true
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 1000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            binding.rasp.goBack()
        }
        backPressedTime = System.currentTimeMillis()
    }
}


package com.example.studenthelper

import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthelper.databinding.ActivityMailBinding

class Mail : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var binding: ActivityMailBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)
        binding = ActivityMailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        binding.mail.webViewClient = WebViewClient()

        binding.mail.apply {
            loadUrl("https://letter.tpu.ru/mail/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.domStorageEnabled = true
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 1000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            binding.mail.goBack()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
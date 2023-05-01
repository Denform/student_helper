package com.example.studenthelper

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.studenthelper.databinding.ActivityPayDormitoryBinding

class PayDormitory : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var binding: ActivityPayDormitoryBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_dormitory)
        binding = ActivityPayDormitoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        binding.dormitoryPay.webViewClient = WebViewClient()

        binding.dormitoryPay.apply {
            loadUrl("https://wildfly.tpu.ru/pay/service/1ec9ad98-0867-11e6-9455-005056a55739")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.domStorageEnabled = true
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 1000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            binding.dormitoryPay.goBack()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
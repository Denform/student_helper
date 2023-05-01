package com.example.studenthelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthelper.databinding.ActivityPayBinding

class Pay : AppCompatActivity() {

    private lateinit var binding: ActivityPayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.educPay.setOnClickListener{
            val intent = Intent(this, PayEducation::class.java)
            startActivity(intent)
        }

        binding.internet.setOnClickListener{
            val intent = Intent(this, PayInternet::class.java)
            startActivity(intent)
        }

        binding.dom.setOnClickListener{
            val intent = Intent(this, PayDormitory::class.java)
            startActivity(intent)
        }
    }
}
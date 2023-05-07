package com.example.studenthelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthelper.databinding.ActivityMainBinding
import com.example.studenthelper.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference:SharedPreference = SharedPreference(this)
        binding.userLogin.setText(sharedPreference.getValueString("login"))

        binding.btnLogout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.mail.setOnClickListener{
            val intent = Intent(this, Mail::class.java)
            startActivity(intent)
        }

        binding.rasp.setOnClickListener{
            val intent = Intent(this, Rasp::class.java)
            startActivity(intent)
        }

        binding.pay.setOnClickListener{
            val intent = Intent(this, Pay::class.java)
            startActivity(intent)
        }

        binding.MyStepa.setOnClickListener{
            val intent = Intent(this, Scholarship::class.java)
            startActivity(intent)
        }

        binding.sitePrepod.setOnClickListener{
            val intent = Intent(this, PersonalPage::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {

    }
}
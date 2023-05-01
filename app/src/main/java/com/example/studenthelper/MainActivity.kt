package com.example.studenthelper

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference:SharedPreference = SharedPreference(this)

        binding.btnLogin.setOnClickListener{
            sharedPreference.save("login", binding.loginIn.text.toString())
            sharedPreference.save("password", binding.passIn.text.toString())
//            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(baseContext, getString(R.string.msgOut), Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
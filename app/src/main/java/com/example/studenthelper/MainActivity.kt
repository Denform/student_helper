package com.example.studenthelper

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
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

        if (sharedPreference.getValueString("login") != ""){
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            if ((binding.loginIn.text.isNotEmpty()) && (binding.passIn.text.isNotEmpty())) {
                if (binding.loginIn.text.toString().isEmailValid() == true) {
                    sharedPreference.save("login", binding.loginIn.text.toString())
                    sharedPreference.save("password", binding.passIn.text.toString())

                    val intent = Intent(this, MainMenu::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, getString(R.string.errorEmail), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.emptyData), Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(this, getString(R.string.msgOut), Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}
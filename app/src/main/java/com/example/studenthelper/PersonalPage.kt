package com.example.studenthelper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthelper.databinding.ActivityPersonalPageBinding
import java.net.URI

class PersonalPage : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_page)
        binding = ActivityPersonalPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val FIO = "Фадеев Александр Сергеевич"
        val photo = "https://portal.tpu.ru/foto/7552.jpg"
        val grade = "Кандидат технических наук"
        val position = "Инженерная школа информационных технологий и робототехники, Директор\n" +
                "Управление проректора по цифровизации, Исполняющий обязанности руководителя\n" +
                "Управление проректора по цифровизации, Заместитель проректора по цифровизации\n" +
                "Отделение информационных технологий, Доцент"
        val phone = "8 (3822) 70-63-30"
        val inner_phone = "2117"
        val email = "fas@tpu.ru"

        binding.FIO.setText(FIO)
//        binding.photo.setImageURI(URI.parse())
        binding.info.setText(grade + "\n\n" + position + "\n\n" +
                "Тел.: " + phone + "\nВн.телефон: " + inner_phone + "\nE-mail: " + email)
    }
}
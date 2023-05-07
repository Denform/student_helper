package com.example.studenthelper

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthelper.databinding.ActivityScholarshipBinding

class Scholarship : AppCompatActivity() {

    private lateinit var binding: ActivityScholarshipBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scholarship)
        binding = ActivityScholarshipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val months = arrayOf("2023 Май", "2023 Апрель", "2023 Март", "2023 Февраль")
        val spinner: Spinner = findViewById(R.id.monthsSpinner)
        val adapter = ArrayAdapter(
            this, // Context
            R.drawable.months_spinner_item, // Layout
            months // Array
        )
        adapter.setDropDownViewResource(
            R.drawable.months_spinner_item
        )
        spinner.adapter = adapter;
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent:AdapterView<*>,
                view: View, position: Int, id: Long) {

            }
            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        val stepa = 3500.00F
        val kef = 1050.00F
        val profvznosi = 136.50F
        val account_number = 156546485465653165
        val bank_name = "Ф-Л БАНКА ГПБ (АО) В Г. ТОМСКЕ"
        val bik = 658975
        binding.accrued.setText("Начислено:\n" +
                "Стипендия студентам - $stepa\n" +
                "Районный коэффициент - $kef\n" +
                "Всего начисленно - ${stepa + kef}")
        binding.withheld.setText("Удержано:\n" +
                "Профвзносы - $profvznosi\n" +
                "Всего удержано - $profvznosi")
        binding.paid.setText("Выплачено:\n" +
                "Всего выплат - ${stepa + kef - profvznosi}")
        binding.personalAccount.setText("Мой лицевой счет:\n" +
                "Номер - $account_number\n" +
                "Название банка - $bank_name\n" +
                "БИК - $bik")


    }
}
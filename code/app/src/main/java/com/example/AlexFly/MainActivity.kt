package com.example.AlexFly

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.AlexFly.calendar.CalendarActivity
import com.example.AlexFly.city.CitysActivityFrome
import com.example.AlexFly.city.CitysActivityTo
import com.example.AlexFly.ticket.TicketActivity

class MainActivity : AppCompatActivity() {
    private var city1: String = "Минск"
    private var city2: String = "Москва"
    private var date: String = "07.11.2024"

    private lateinit var mainCity1: TextView
    private lateinit var mainCity2: TextView
    private lateinit var mainDate: TextView
    private lateinit var mainButton: Button

    companion object {
        private const val REQUEST_CODE_CITY_FROM = 1
        private const val REQUEST_CODE_CITY_TO = 2
        private const val REQUEST_CODE_DATE = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainCity1 = findViewById(R.id.main_city1)
        mainCity2 = findViewById(R.id.main_city2)
        mainDate = findViewById(R.id.main_date)
        mainButton = findViewById(R.id.main_button)

        // Установите текст по умолчанию
        mainCity1.text = "Место вылета - $city1"
        mainCity2.text = "Место прилёта - $city2"
        mainDate.text = "Дата вылета - $date"

        mainCity1.setOnClickListener {
            val intent = Intent(this, CitysActivityFrome::class.java)
            startActivityForResult(intent, REQUEST_CODE_CITY_FROM)
        }
        mainCity2.setOnClickListener {
            val intent = Intent(this, CitysActivityTo::class.java)
            startActivityForResult(intent, REQUEST_CODE_CITY_TO)
        }
        mainDate.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_DATE)
        }

        mainButton.setOnClickListener {
            val intentTick = Intent(this, TicketActivity::class.java)
            intentTick.putExtra("city1", city1)
            Log.d("MainActivity", "city1 otpravka: $city1") // Добавьте лог для отладки
            intentTick.putExtra("city2", city2)
            Log.d("MainActivity", "city2 otpravka: $city2") // Добавьте лог для отладки
            intentTick.putExtra("date", date)
            Log.d("MainActivity", "date otpravka: $date") // Добавьте лог для отладки
            startActivity(intentTick)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_CITY_FROM -> {
                    city1 = data?.getStringExtra("city") ?: city1
                    mainCity1.text = "Место вылета - $city1" // Обновляем текст
                }
                REQUEST_CODE_CITY_TO -> {
                    city2 = data?.getStringExtra("city") ?: city2
                    mainCity2.text = "Место прилёта - $city2" // Обновляем текст
                }
                REQUEST_CODE_DATE -> {
                    date = data?.getStringExtra("date") ?: date
                    mainDate.text = "Дата вылета - $date" // Обновляем текст
                }
            }
        }
    }
}
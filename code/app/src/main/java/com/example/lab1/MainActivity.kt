package com.example.lab1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab1.calendar.CalendarActivity
import com.example.lab1.city.CitysActivityFrome
import com.example.lab1.city.CitysActivityTo
import com.example.lab1.ticket.TicketActivity

class MainActivity : AppCompatActivity() {

    private lateinit var str: String
    private lateinit var city1: String
    private lateinit var city2: String
    private lateinit var date: String



    companion object {
        private const val REQUEST_CODE_CITY_FROM = 1
        private const val REQUEST_CODE_CITY_TO = 2
        private const val REQUEST_CODE_DATE = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Запускаем первую активность
        val intentCityFrom = Intent(this, CitysActivityFrome::class.java)
        startActivityForResult(intentCityFrom, REQUEST_CODE_CITY_FROM)
    }

    // эта функция всегда используется системой Android, когда активность запущенна startActivityForResult() и возвращает результат
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_CITY_FROM -> {
                if (resultCode == Activity.RESULT_OK) {
                    city1 = data?.getStringExtra("city") ?: "No city1" // Используйте data вместо intent
                    val intentCityTo = Intent(this, CitysActivityTo::class.java)
                    startActivityForResult(intentCityTo, REQUEST_CODE_CITY_TO)
                }
            }
            REQUEST_CODE_CITY_TO -> {
                if (resultCode == Activity.RESULT_OK) {
                    city2 = data?.getStringExtra("city") ?: "No city2" // Используйте data вместо intent
                    val intentCalendar = Intent(this, CalendarActivity::class.java)
                    startActivityForResult(intentCalendar, REQUEST_CODE_DATE)
                }
            }
            REQUEST_CODE_DATE -> {
                if (resultCode == Activity.RESULT_OK) {
                    date = data?.getStringExtra("date") ?: "No date" // Используйте data вместо intent
                    val intentTick = Intent(this, TicketActivity::class.java)
                    intentTick.putExtra("city1", city1)
                    intentTick.putExtra("city2", city2)
                    intentTick.putExtra("date", date)
                    startActivity(intentTick)
                }
            }
        }
    }
}
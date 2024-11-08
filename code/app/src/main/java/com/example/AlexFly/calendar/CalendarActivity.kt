package com.example.AlexFly.calendar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.AlexFly.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var selectedDateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calendarView = findViewById(R.id.calendarView)
        selectedDateText = findViewById(R.id.text_calendar)

        val buttonBack: Button = findViewById(R.id.button_back)

        // Установка минимальной и максимальной дат
        val minDate = Calendar.getInstance()
        minDate.add(Calendar.DAY_OF_MONTH, -30) // 30 дней назад
        calendarView.minDate = minDate.timeInMillis

        val maxDate = Calendar.getInstance()
        maxDate.add(Calendar.MONTH, 6)  // 6 месяцев вперед
        calendarView.maxDate = maxDate.timeInMillis

        // Изменение цвета выделения выбранной даты
        calendarView.setSelectedDateVerticalBar(R.color.black)

        // Изменение первого дня недели
        calendarView.firstDayOfWeek = Calendar.MONDAY

        updateSelectedDate(Calendar.getInstance().timeInMillis) // Установка начальной даты (сегодняшней)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            // Обновляем выбранную дату и получаем строку
            val str = updateSelectedDate(calendar.timeInMillis)

            // Создаем Intent для передачи результата
            val resultIntent = Intent()
            resultIntent.putExtra("date", str)

            setResult(Activity.RESULT_OK, resultIntent) // Устанавливаем результат
            finish() // Закрываем активность
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun updateSelectedDate(date: Long): String {
        // Форматируем дату в нужном формате "dd-MM-yyyy"
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(Date(date))
        selectedDateText.text = "Выбранная дата: $formattedDate"
        return formattedDate // Возвращаем только дату в формате "dd-MM-yyyy"
    }
}
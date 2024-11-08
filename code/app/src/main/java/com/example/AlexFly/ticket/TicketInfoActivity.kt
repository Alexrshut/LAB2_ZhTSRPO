package com.example.AlexFly.ticket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.AlexFly.R
import com.example.AlexFly.account.PersAccount
import com.google.gson.Gson

class TicketInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ticket_info)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация TextView
        val ticketRouteInfo: TextView = findViewById(R.id.ticket_route_info)
        val ticketPrice: TextView = findViewById(R.id.ticket_price)
        val ticketAirlineName: TextView = findViewById(R.id.ticket_airline_name)
        val ticketDepartureTime: TextView = findViewById(R.id.ticket_departure_time)
        val ticketFlightDuration: TextView = findViewById(R.id.ticket_flight_duration)
        val ticketDepartureCity: TextView = findViewById(R.id.ticket_departure_city)
        val ticketArrivalCity: TextView = findViewById(R.id.ticket_arrival_city)
        val ticketDepartureDate: TextView = findViewById(R.id.ticket_departure_date)
        val ticketTransferInfo: TextView = findViewById(R.id.ticket_transfer_info)
        val ticketArrivalDate: TextView = findViewById(R.id.ticket_arrival_date)

        val buttonPurchase: Button = findViewById(R.id.button_purchase)
        val buttonBack: Button = findViewById(R.id.button_back)

        // Получение JSON-строки из Intent
        val ticketJson = intent.getStringExtra("ticketInfo")
        val gson = Gson()
        val ticket: Ticket? = gson.fromJson(ticketJson, Ticket::class.java)

        // Проверка, что объект ticket не равен null
        if (ticket != null) {
            var str: String = "${ticket.city1} — ${ticket.city2}"
            ticketRouteInfo.text = str

            str = "Цена: ${ticket.price} BYN"
            ticketPrice.text = str

            str = "Авиакомпания: ${ticket.company}"
            ticketAirlineName.text = str

            str = "Время вылета: ${ticket.time1}"
            ticketDepartureTime.text = str

            str = "Время в пути: ${ticket.time}"
            ticketFlightDuration.text = str

            str = "Город вылета: ${ticket.city1} (${ticket.code1})"
            ticketDepartureCity.text = str

            str = "Город прилёта: ${ticket.city2} (${ticket.code2})"
            ticketArrivalCity.text = str

            str = "Дата вылета: ${ticket.date1}"
            ticketDepartureDate.text = str

            str = "Пересадка: ${ticket.per}"
            ticketTransferInfo.text = str

            str = "Дата прилёта: ${ticket.date2}"
            ticketArrivalDate.text = str
        } else {
            // Обработка случая, когда объект Ticket не удалось создать
            Toast.makeText(this, "Ошибка загрузки данных рейса", Toast.LENGTH_SHORT).show()
        }

        // Установка обработчиков нажатий для кнопок
        buttonPurchase.setOnClickListener {
            val intent = Intent(this, PersAccount::class.java)
            intent.putExtra("login", "Alexrshut")
            intent.putExtra("pass", "123")
            startActivity(intent)
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
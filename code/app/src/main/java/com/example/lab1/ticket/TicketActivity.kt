package com.example.lab1.ticket

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.R

class TicketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ticket)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ticketList: RecyclerView = findViewById(R.id.list_tc)
        val ticket = arrayListOf<Ticket>()

        ticket.add(Ticket(332, "АЭРОФЛОТ", "5:00", "Минск", "Москва", "20:00", "01:10", "MSQ", "SVO", "Санкт-Петербург", "22:50", "16-10-2024"))
        ticket.add(Ticket(432, "АЭРОФЛОТ", "6:00", "Минск", "Cанкт-Петербург", "20:00", "02:10", "MSQ", "LED", "Витебск", "23:00", "16-10-2024"))
        ticket.add(Ticket(532, "АЭРОФЛОТ", "7:00", "Минск", "Москва", "22:00", "00:30", "MSQ", "SVO", "Санкт-Петербург", "22:50", "16-10-2024"))
        ticket.add(Ticket(632, "ПОБЕДА", "5:00", "Минск", "Москва", "20:00", "01:10", "MSQ", "SVO", "Санкт-Петербург", "22:50", "17-10-2024"))
        ticket.add(Ticket(732, "ПОБЕДА", "6:00", "Минск", "Cанкт-Петербург", "20:00", "02:10", "MSQ", "LED", "Витебск", "23:00", "17-10-2024"))
        ticket.add(Ticket(832, "ПОБЕДА", "7:00", "Минск", "Москва", "22:00", "00:30", "MSQ", "SVO", "Санкт-Петербург", "22:55", "17-10-2024"))
        ticket.add(Ticket(932, "БЕЛАВИА", "5:00", "Минск", "Москва", "20:00", "01:10", "MSQ", "SVO", "Санкт-Петербург", "22:50", "18-10-2024"))
        ticket.add(Ticket(1032, "БЕЛАВИА", "6:00", "Минск", "Cанкт-Петербург", "20:00", "02:10", "MSQ", "LED", "Витебск", "23:00", "18-10-2024"))
        ticket.add(Ticket(1032, "БЕЛАВИА", "7:00", "Минск", "Москва", "22:00", "00:30", "MSQ", "SVO", "Санкт-Петербург", "22:55", "19-10-2024"))


        // Получаем значения city1 и city2 из Intent
        val city1 = intent.getStringExtra("city1") ?: ""
        val city2 = intent.getStringExtra("city2") ?: ""
        val date = intent.getStringExtra("date")?: ""

        // Фильтруем билеты
        val filteredTickets = ticket.filter {
            it.city1 == city1 && it.city2 == city2 && it.date == date
        }

        // Устанавливаем LayoutManager и Adapter
        ticketList.layoutManager = LinearLayoutManager(this)
        ticketList.adapter = TicketAdapter(filteredTickets, this)
    }
}
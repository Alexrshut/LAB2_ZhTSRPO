package com.example.AlexFly.ticket

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AlexFly.R
import com.google.gson.Gson
import java.io.InputStreamReader
import com.google.gson.reflect.TypeToken

class TicketActivity : AppCompatActivity() {
    private lateinit var ticketList: RecyclerView
    private lateinit var ticketAdapter: TicketAdapter
    private var tickets = listOf<Ticket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ticket)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBack: Button = findViewById(R.id.button_back)

        ticketList = findViewById(R.id.list_tc)
        tickets = loadTicketsFromJson(this)

        // Получаем значения city1 и city2 из Intent
        val city1 = intent.getStringExtra("city1") ?: ""
        val city2 = intent.getStringExtra("city2") ?: ""
        val date1 = intent.getStringExtra("date") ?: ""

        // Фильтруем билеты
        val filteredTickets = tickets.filter {
            it.city1 == city1 && it.city2 == city2 && it.date1 == date1
        }

        // Устанавливаем LayoutManager и Adapter
        ticketList.layoutManager = LinearLayoutManager(this)
        ticketAdapter = TicketAdapter(filteredTickets, this)
        ticketList.adapter = ticketAdapter

        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun loadTicketsFromJson(context: Context): List<Ticket> {
        val inputStream = context.assets.open("tickets.json")
        Log.d("TicketActivity", "1")
        val reader = InputStreamReader(inputStream)
        Log.d("TicketActivity", "2")
        val ticketListType = object : TypeToken<List<Ticket>>() {}.type
        Log.d("TicketActivity", "3")
        return Gson().fromJson(reader, ticketListType)
    }
}
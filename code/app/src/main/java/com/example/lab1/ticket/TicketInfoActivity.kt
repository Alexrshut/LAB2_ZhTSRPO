package com.example.lab1.ticket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab1.R
import com.example.lab1.account.PersAccount

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

        val city1City2TcInfo: TextView = findViewById(R.id.city1city2_tc_info)
        val priceTcInfo: TextView = findViewById(R.id.price_tc_info)
        val timeTcInfo: TextView = findViewById(R.id.time_tc_info)
        val companyTcInfo: TextView = findViewById(R.id.company_tc_info)
        val perTcInfo: TextView = findViewById(R.id.per_tc_info)
        val time1TcInfo: TextView = findViewById(R.id.time1_tc_info)
        val city1: TextView = findViewById(R.id.city1_tc_info)
        val data1TcInfo: TextView = findViewById(R.id.data1_tc_info)
        val city1Code1TcInfo: TextView = findViewById(R.id.city1code1_tc_info)
        val time2TcInfo: TextView = findViewById(R.id.time2_tc_info)
        val city2: TextView = findViewById(R.id.city2_tc_info)
        val data2TcInfo: TextView = findViewById(R.id.data2_tc_info)
        val city2Code2TcInfo: TextView = findViewById(R.id.city2code2_tc_info)

        val button1: Button = findViewById(R.id.button1_tc_info)
        val button2: Button = findViewById(R.id.button2_tc_info)

        val ticket: Ticket? = intent.getParcelableExtra<Ticket>("ticketInfo")

        if (ticket != null) {
            var str: String = ""
            str = "${ticket.city1} — ${ticket.city2}"
            city1City2TcInfo.text = str

            priceTcInfo.text = ticket.price.toString()
            timeTcInfo.text = ticket.time
            companyTcInfo.text = ticket.company

            str = "Пересадка в городе ${ticket.per} в ${ticket.timeper}"
            perTcInfo.text = str

            time1TcInfo.text = ticket.time1
            city1.text = ticket.city1

            str = "13.10.2024"
            data1TcInfo.text = str

            str = "${ticket.city1} ${ticket.code1}"
            city1Code1TcInfo.text = str

            str = "14.10.2024"
            data2TcInfo.text = str

            str = "${ticket.city2} ${ticket.code2}"
            city2Code2TcInfo.text = str

            time2TcInfo.text = ticket.time2
            city2.text = ticket.city2
        }

        button1.setOnClickListener {
            val intent = Intent(this, PersAccount::class.java)
            intent.putExtra("login", "Alexrshut")
            intent.putExtra("pass", "123")
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, TicketActivity::class.java)
            startActivity(intent)
        }
    }
}
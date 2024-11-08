package com.example.AlexFly.ticket

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.AlexFly.R
import com.google.gson.Gson

class TicketAdapter(private var tickets: List<Ticket>, private val context: Context) : RecyclerView.Adapter<TicketAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val price: TextView = view.findViewById(R.id.price_tc)
        val company: TextView = view.findViewById(R.id.company_tc)
        val time1: TextView = view.findViewById(R.id.time1_tc)
        val time2: TextView = view.findViewById(R.id.time2_tc)
        val code1: TextView = view.findViewById(R.id.code1_tc)
        val code2: TextView = view.findViewById(R.id.code2_tc)
        val time: TextView = view.findViewById(R.id.time_tc)
        val per: TextView = view.findViewById(R.id.per_tc)
        val date: TextView = view.findViewById(R.id.date_tc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ticket = tickets[position]
        holder.price.text = ticket.price.toString()
        holder.company.text = ticket.company
        holder.time1.text = ticket.time1
        holder.time2.text = ticket.time2
        holder.code1.text = ticket.code1
        holder.code2.text = ticket.code2
        holder.time.text = ticket.time
        holder.per.text = ticket.per
        holder.date.text = ticket.date1

        holder.itemView.setOnClickListener {
            val gson = Gson()
            val ticketJson = gson.toJson(ticket)  // Преобразуем объект Ticket в JSON
            val intent = Intent(context, TicketInfoActivity::class.java)
            intent.putExtra("ticketInfo", ticketJson)  // Передаём JSON-строку
            context.startActivity(intent)
        }
    }
}
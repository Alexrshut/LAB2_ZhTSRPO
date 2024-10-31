package com.example.lab1.city

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.R

// Собственный класс адаптер для вывода моего класса Item в стиле дизайна item_in_list.xml
class CitysAdapter(private val citys: List<City>, private val activity: Activity) : RecyclerView.Adapter<CitysAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) { // Собственный класс для обращения к полям дизайна
        val point: TextView = view.findViewById(R.id.point_city)
        val name: TextView = view.findViewById(R.id.name_city)
        val location: TextView = view.findViewById(R.id.location_city)
        val code: TextView = view.findViewById(R.id.code_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // Создает элементы дизайна
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return citys.count() // Возвращает количество элементов в списке
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // Соответствие полей из класса Item полям дизайна
        holder.point.text = citys[position].point
        holder.name.text = citys[position].name
        holder.location.text = citys[position].location
        holder.code.text = citys[position].code

        holder.itemView.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("city", citys[position].point)
            activity.setResult(Activity.RESULT_OK, resultIntent) // Устанавливаем результат
            activity.finish() // Закрываем активность
        }
    }
}
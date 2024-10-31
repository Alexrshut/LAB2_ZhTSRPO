package com.example.lab1.city

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.MainActivity
import com.example.lab1.R

class CitysActivityTo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_citys_to)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val citysList: RecyclerView = findViewById(R.id.list_vb_city1)
        val citys = arrayListOf<City>()

        citys.add(City(1,"Санкт-Петербург", "Санкт-Петербург", "Россия", "LED"))
        citys.add(City(2,"Минск", "Минск", "Беларусь", "MSQ"))
        citys.add(City(3,"Москва", "Шереметьево", "Беларусь", "SVO"))

        citysList.layoutManager = LinearLayoutManager(this)//формат в котором буду распологаться все элементы
        citysList.adapter = CitysAdapter(citys, this)//устанавливаю свой адаптер
    }
}
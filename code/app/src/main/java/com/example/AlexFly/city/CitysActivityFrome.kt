package com.example.AlexFly.city

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AlexFly.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class CitysActivityFrome : AppCompatActivity() {
    private lateinit var citysList: RecyclerView
    private lateinit var citysAdapter: CitysAdapter
    private var citys = listOf<City>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_citys_frome)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        citysList = findViewById(R.id.list_vb_city1)
        val buttonBack: Button = findViewById(R.id.button_back)

        // Загружаем города из JSON файла
        citys = loadСitysFromJson(this)

        // Устанавливаем LayoutManager и Adapter
        citysList.layoutManager = LinearLayoutManager(this)
        citysAdapter = CitysAdapter(citys, this)
        citysList.adapter = citysAdapter

        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun loadСitysFromJson(context: Context): List<City> {
        val inputStream = context.assets.open("citys.json")
        val reader = InputStreamReader(inputStream)
        val citysListType = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(reader, citysListType)
    }
}
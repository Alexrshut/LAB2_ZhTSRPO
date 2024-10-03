package com.example.lab1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)
        //val label = findViewById<TextView>(R.id.text_hello)
        val userData: EditText = findViewById(R.id.user_name)
        val button: Button = findViewById(R.id.button)

        val todos: MutableList<String> = mutableListOf(); //создание пустого массива дл я хранения значений листа
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos) //используем встроеный стиль android, при желании можно создать отдельный файл дизайна
        listView.adapter = adapter //указали используемый адаптер для нашего листа

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)
            Toast.makeText(this, "Мы удалили пользователя: $text !", Toast.LENGTH_LONG).show()
        }



    }

}
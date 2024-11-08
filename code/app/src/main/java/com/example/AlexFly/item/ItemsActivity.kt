package com.example.AlexFly.item

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.AlexFly.R

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "ak74", "Боевой АК-74", "Легендарный автомат!", "Этот автомат прошол через много и купить вы его можете у нас.", 1200 ))
        items.add(Item(2, "ak12", "Боевой АК-12", "Новейший лёгкий автомат!", "Этот автомат прошол через много и купить вы его можете у нас.", 2500 ))
        items.add(Item(3, "ak15", "Боевой АК-15", "Новейший тяжёлый автомат!", "Этот автомат прошол через много и купить вы его можете у нас.", 3000 ))

        itemsList.layoutManager = LinearLayoutManager(this) //формат в котором буду распологаться все элементы
        itemsList.adapter = ItemsAdapter(items, this) //устанавливаю свой адаптер
    }
}
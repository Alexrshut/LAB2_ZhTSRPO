package com.example.lab1.item

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.R

//собственый класс адаптер для вывода моего класса Item в стиле дизайна item_in_list.xml
class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){ // собственный класс, которой как бы позволяет обращаться к полям дизайна
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val desc: TextView = view.findViewById(R.id.item_list_desc)
        val price: TextView = view.findViewById(R.id.item_list_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { //создаёт мои дизайн и его поля
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count() // возвращает количество элементов в листе
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // указывает как поля из класса Item соответсвует полю дизайна
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString()

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName )

        holder.image.setImageResource(imageId)
    }

}
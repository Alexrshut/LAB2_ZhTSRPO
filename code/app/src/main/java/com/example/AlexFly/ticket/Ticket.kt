package com.example.AlexFly.ticket

// import android.os.Parcelable - для более быстрой сериализации чем JSON, но менее понять чем JSON

data class Ticket(
    val id: Int, //номер рейса
    val price: Int, //цена в белорусских рублях
    val company: String, //компания по перевозке
    val time: String, //время полёта
    val city1: String, //город вылета
    val city2: String, //город прилёта
    val time1: String, //время на момент вылета
    val time2: String, //время на момент прилёта
    val code1: String, //код города один
    val code2: String, //код города два
    val per: String, //город пересадки(если нет - пустое)
    val timeper: String, //время восколько пересадка
    val date1: String, // поле с датой вылета
    val date2: String //поле с датой прилёта
)
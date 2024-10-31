package com.example.lab1.ticket

import android.os.Parcel
import android.os.Parcelable

data class Ticket(
    val price: Int,
    val company: String,
    val time: String,
    val city1: String,
    val city2: String,
    val time1: String,
    val time2: String,
    val code1: String,
    val code2: String,
    val per: String,
    val timeper: String,
    val date: String // Добавлено поле с датой
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "" // Для String даты
        // или
        // parcel.readLong() // Для Long даты
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(price)
        parcel.writeString(company)
        parcel.writeString(time)
        parcel.writeString(city1)
        parcel.writeString(city2)
        parcel.writeString(time1)
        parcel.writeString(time2)
        parcel.writeString(code1)
        parcel.writeString(code2)
        parcel.writeString(per)
        parcel.writeString(timeper)
        parcel.writeString(date) // Для String даты
        // или
        // parcel.writeLong(date) // Для Long даты
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ticket> {
        override fun createFromParcel(parcel: Parcel): Ticket {
            return Ticket(parcel)
        }

        override fun newArray(size: Int): Array<Ticket?> {
            return arrayOfNulls(size)
        }
    }
}

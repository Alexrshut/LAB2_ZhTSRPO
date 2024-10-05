package com.example.lab1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app_les2", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) { // ? - означает, может быть значение null
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query) // отправляем наш запрос query в базу данных (!! - означает обрабатываем null)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { //удаление таблицы в БД
        db!!.execSQL("DROP TABLE IF EXISTS users") //отпраляем запрос на удаление таблицы в базе данных
        onCreate(db)
    }

    fun addUser(user: User){ //добавляем значения в таблицу
        val values = ContentValues() //создаём перенную для записи в базу данных
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase //работаем с записью в БД
        db.insert("users", null, values) //записываем в базу данных

        db.close()
    }

    fun isExistsUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase //работаем с чтением в БД
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)// записываем SQL команду, null - второй аргумент, так как мы все значения подставили в условии, а не через массив
        return result.moveToFirst()//try - если пользователь существует, false - нет
    }

    fun getUser(login: String, pass: String): User? {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)
        return if (result.moveToFirst()) { // проверяю если что в курсоре
            User(result.getString(1), result.getString(2), result.getString(3))
        } else {
            null
        }
    }

}


/// execSQL() - не возвращает курсор, поэтому его нельзя использовать для запросов SELECT1.
// rawQuery, который возвращает курсор с результатами запроса
package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userLoginAuth: EditText = findViewById(R.id.user_login_auth)
        val userPassAuth: EditText = findViewById(R.id.user_password_auth)
        val buttonAuth: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java) //Здесь ты создаешь объект Intent, который указывает, что ты хочешь перейти от текущей активности к AuthActivity.
            startActivity(intent) //Этот метод запускает startActivity, используя созданный Intent.
            //Таким образом, при нажатии на link_to_reg, приложение переходит на startActivity.
        }

        buttonAuth.setOnClickListener{
            val login = userLoginAuth.text.toString().trim()
            val pass = userPassAuth.text.toString().trim()

            if(login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.isExistsUser(login, pass)

                if(isAuth){
                    //Toast.makeText(this, "Пользователь $login уже авторизован!", Toast.LENGTH_LONG).show()
                    //userLoginAuth.text.clear()
                    //userPassAuth.text.clear()
                    val intent = Intent(this, PersAccount::class.java)
                    intent.putExtra("login", login) // добавляем строковое значение login с ключом "login" в Intent
                    intent.putExtra("pass", pass) // добавляем строковое значение pass с ключом "pass" в Intent
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Пользователь $login ещё неавторизован!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
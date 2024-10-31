package com.example.lab1.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab1.R
import com.example.lab1.database.DbHelper

class PersAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pers_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userLoginPc: TextView = findViewById(R.id.user_login_ps)
        val userEmailPc: TextView = findViewById(R.id.user_email_ps)
        val userPassPc: TextView = findViewById(R.id.user_pass_ps)
        val buttonPc: Button = findViewById(R.id.button_pc)



        val login = intent.getStringExtra("login")
        val pass = intent.getStringExtra("pass")

        val db = DbHelper(this, null)
        val user = db.getUser(login.toString(), pass.toString())

        if (user != null) {
            userLoginPc.text = user.login
            userEmailPc.text = user.email
            userPassPc.text = user.pass
        } else {
            Toast.makeText(this, "Ошибка при запросе данных из БД!", Toast.LENGTH_LONG).show()
        }

        buttonPc.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }
}
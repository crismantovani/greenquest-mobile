package br.com.greenquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val btnSignup = findViewById<Button>(R.id.btnLinkSignUp)

        btnLogin.setOnClickListener {
            val i = Intent(this, Home::class.java)
            startActivity(i)

        }

        btnSignup.setOnClickListener {
            val i = Intent(this, SignUp::class.java)
            startActivity(i)

        }

    }

}
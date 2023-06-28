package br.com.greenquest

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import br.com.greenquest.R.id.btnLeagues

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val btnleagues = findViewById< ImageButton>(btnLeagues)

        btnleagues.setOnClickListener {
            val i = Intent(this, LeaguesActivity::class.java)
            startActivity(i)

        }

        val btnlearn = findViewById< ImageButton>(R.id.btnLearn)

        btnlearn.setOnClickListener {
            val i = Intent(this, LearnActivity::class.java)
            startActivity(i)

        }

    }
}
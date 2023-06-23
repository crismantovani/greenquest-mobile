package br.com.greenquest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnLogin.setOnClickListener {
            val i = Intent(this, Home::class.java)
            startActivity(i)

        }

        val textView = findViewById<TextView>(R.id.linkRegister)

        val text = "Não tem uma conta? Registre-se aqui"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Ação a ser executada quando o hiperlink é clicado
                val intent = Intent(this@MainActivity, SignUp::class.java)
                startActivity(intent)
            }
        }

        val startIndex = text.indexOf("aqui")
        val endIndex = startIndex + "aqui".length

        spannableString.setSpan(clickableSpan, startIndex, endIndex, 0)

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

}

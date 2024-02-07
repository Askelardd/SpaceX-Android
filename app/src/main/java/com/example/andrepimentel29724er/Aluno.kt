package com.example.andrepimentel29724er

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Aluno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno)

        val botaotoCrew: Button = findViewById(R.id.buttonUsers)
        botaotoCrew.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Results: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchesquiz)

        val edit: Button = findViewById(R.id.resprofile)
        edit.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
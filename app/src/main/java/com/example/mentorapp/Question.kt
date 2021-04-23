package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class Question: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        val edit: Button = findViewById(R.id.submit)
        edit.setOnClickListener{
            startActivity(Intent(this, Results::class.java))
        }

    }
}
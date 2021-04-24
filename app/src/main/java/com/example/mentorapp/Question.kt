package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class Question: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        val answer1: RadioGroup = findViewById(R.id.Question1)
        val answer2: RadioGroup = findViewById(R.id.Question2)
        val answer3: Spinner = findViewById(R.id.Question3)
        val answer4: Spinner = findViewById(R.id.Question4)
        val answer5: RadioGroup = findViewById(R.id.Question5)
        val answer6: RadioGroup = findViewById(R.id.Question6)


        val edit: Button = findViewById(R.id.submit)
        edit.setOnClickListener{
            startActivity(Intent(this, Results::class.java))
        }

    }
}
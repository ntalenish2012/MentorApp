package com.example.mentorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit: Button = findViewById(R.id.EditInfo)
        edit.setOnClickListener{
            startActivity(Intent(this, EditUser::class.java))
        }

        val question: Button = findViewById(R.id.Questionnaire)
        question.setOnClickListener{
            startActivity(Intent(this, Question::class.java))
        }

    }
    // TODO: pull data to go in the text fields
}


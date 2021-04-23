package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EditUser: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val save: Button = findViewById(R.id.save)
        save.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        val cancel: Button = findViewById(R.id.cancel)
        cancel.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
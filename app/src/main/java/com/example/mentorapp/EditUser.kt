package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditUser: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name: TextView = findViewById(R.id.name2)
        val role: TextView = findViewById(R.id.role2)
        val email: TextView = findViewById(R.id.email2)
        val bio: TextView = findViewById(R.id.bio2)

        val save: Button = findViewById(R.id.save)
        save.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        val cancel: Button = findViewById(R.id.cancel)
        cancel.setOnClickListener{
            finish()
        }

    }
}
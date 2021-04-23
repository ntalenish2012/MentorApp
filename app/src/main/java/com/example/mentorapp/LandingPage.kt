package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.mentorapp.UserData


class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.initialize(applicationContext)

        UserData.isSignedIn.observe(this) { isSignedUp ->
            if (isSignedUp) {
                startActivity(Intent(this, MainActivity::class.java))
                Log.i("landingpage ", "true")
                finish()

            } else {
                startActivity(Intent(this, LogIn::class.java))
                Log.i("landingpage ", "false")
                finish()
            }

        }
    }
}
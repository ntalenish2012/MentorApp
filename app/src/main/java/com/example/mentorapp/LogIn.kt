package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_log_in.*

class LogIn: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
       // setupAuthButton(UserData)

        UserData.isSignedIn.observe(this,{isSignedUp ->
            val button: Button = findViewById(R.id.login)
            button.setOnClickListener{
                System.signIn(this)
            }
            onStart(UserData)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        System.handleWebUISignInResponse(requestCode, resultCode, data)
    }

    private fun onStart(userData: UserData) {
        super.onStart()
        if (userData.isSignedIn.value!!) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun setupAuthButton(userData: UserData) {

        // register a click listener
        login.setOnClickListener { view ->

            view as FloatingActionButton

            if (userData.isSignedIn.value!!) {
                System.signOut()
            } else {
                System.signIn(this)
            }
        }
    }
}
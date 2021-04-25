package com.example.mentorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.observe
import com.amazonaws.mobile.client.AWSMobileClient
import com.amplifyframework.core.Amplify
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_log_in.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       UserData.isSignedIn.observe(this, { isSignedIn ->
            if (isSignedIn) {
                Log.i("TAG"," user loged in")
            }else{
                startActivity(Intent(this, LogIn::class.java))
            }
        })

        val name: TextView = findViewById(R.id.name1)
        val role: TextView = findViewById(R.id.role1)
        val email: TextView = findViewById(R.id.email1)
        val bio: TextView = findViewById(R.id.bio1)


        role.text = AWSMobileClient.getInstance().username


        val edit: Button = findViewById(R.id.EditInfo)
        edit.setOnClickListener{
            startActivity(Intent(this, EditUser::class.java))
        }

        val question: Button = findViewById(R.id.Questionnaire)
        question.setOnClickListener{
            startActivity(Intent(this, Question::class.java))
        }

        val logout: FloatingActionButton = findViewById(R.id.logout)
        logout.setOnClickListener{
            System.signOut()
            Amplify.DataStore.clear(
                { Log.i("TAG", "Cleared DS")},
                {Log.e("TAG","Clear DS Failed")}
            )
        }

        //val logout: Button = findViewById(R.id.Logout)
       // question.setOnClickListener{
          //  startActivity(Intent(this, Question::class.java))
      //  }

    }


    // TODO: pull data to go in the text fields
}


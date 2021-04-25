package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.UserProfile

class EditUser: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name: TextView = findViewById(R.id.name2)
        val role: TextView = findViewById(R.id.role2)
        val email: TextView = findViewById(R.id.email2)
        val bio: TextView = findViewById(R.id.bio2)

        val userName = name.text.toString()
        val userRole = role.text.toString()
        val userEmail = email.text.toString()
        val userBio = bio.text.toString()

        val save: Button = findViewById(R.id.save)
        save.setOnClickListener {
            updateUserProfile(userName, userRole, userEmail, userBio)
            startActivity(Intent(this, MainActivity::class.java))
        }

        val cancel: Button = findViewById(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }

    }

    fun updateUserProfile(name: String, role: String, email: String, bio: String) {
        Amplify.DataStore.query(
            UserProfile::class.java,
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Queried item: " + item.id)
                }
            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )

        Amplify.DataStore.query(UserProfile::class.java, Where.id("123"),
            { items ->
                if (items.hasNext()) {
                    val original = items.next()
                    val edited = original.copyOfBuilder()
                        .name(name)
                        .role(role)
                        .email(email)
                        .bio(bio)
                        .build()
                    Amplify.DataStore.save(edited,
                        { Log.i("MentorApp", "Profile Updated") },
                        { Log.e(",MentorApp", "Profile not updated", it) }
                    )
                }
                val item: UserProfile = UserProfile.builder()
                    .name(name)
                    .email(email)
                    .role(email)
                    .bio(bio)
                    .build()
                Amplify.DataStore.save(
                    item,
                    { success -> Log.i("Amplify", "Saved item: " + success.item().name) },
                    { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
                )

            },
            { Log.e("MentorApp", "Query failed", it) }

        )

    }
}
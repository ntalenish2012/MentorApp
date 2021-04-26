package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.QuizResults
import kotlinx.android.synthetic.main.activity_questionnaire.*

class Question: AppCompatActivity() {
    private lateinit var Qone: String
    private lateinit var Qtwo: String
    private lateinit var Qthree: String
    private lateinit var Qfour: String
    private lateinit var Qfive: String
    private lateinit var Qsix: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        val answer1: RadioGroup = findViewById(R.id.Question1)
        answer1.setOnCheckedChangeListener { _, checked ->
            if (checked == R.id.Question1A) {
                Qone = "firstyr"
            }
            if (checked == R.id.Question1B) {
                Qone = "secondyr"
            }
            if (checked == R.id.Question1C) {
                Qone = "thirdyr"
            }
        }

        val answer2: RadioGroup = findViewById(R.id.Question2)
        answer2.setOnCheckedChangeListener { _, checked ->
            if (
                checked == R.id.Question2A) {
                Qtwo = "firstyr"
            }
            if (checked == R.id.Question2B) {
                Qtwo = "secondyr"
            }
        }


        val answer3: Spinner = findViewById(R.id.Question3)
        Qthree = answer3.selectedItem.toString()

        val answer4: Spinner = findViewById(R.id.Question4)
        Qfour = answer4.selectedItem.toString()

        val answer5: RadioGroup = findViewById(R.id.Question5)
        answer5.setOnCheckedChangeListener { _, checked ->
            if (
                checked == R.id.Question5A) {
                Qfive = "inperson"
            }
            if (
                checked == R.id.Question5B) {
                Qfive = "virtual"
            }
            if (
                checked == R.id.Question5C) {
                Qfive = "n/a"
            }
        }

        val answer6: RadioGroup = findViewById(R.id.Question6)
        answer6.setOnCheckedChangeListener { _, checked ->
            if (
                checked == R.id.Question6A) {
                Qsix = "everyday"
            }
            if (
                checked == R.id.Question6B) {
                Qsix = "week"
            }
            if (
                checked == R.id.Question6C) {
                Qsix = "n/a"
            }
        }

        val edit: Button = findViewById(R.id.submit)
        edit.setOnClickListener {
            /* val theAnswer1 = answer1.checkedRadioButtonId
            val theAnswer2 = answer2.checkedRadioButtonId
            val theAnswer3 = answer3.spinner*/
            saveAnswers(Qone, Qtwo, Qthree, Qfour, Qfive, Qsix)
            startActivity(Intent(this, Results::class.java))
            finish()
        }

    }


    private fun saveAnswers(one: String, two: String, three: String, four: String, five: String, six: String) {
        Amplify.DataStore.query(QuizResults::class.java,
            { items ->
                if (items.hasNext()) {
                    val original = items.next()
                    val edited = original.copyOfBuilder()
                        .qone(one)
                        .qtwo(two)
                        .qthree(three)
                        .qfour(four)
                        .qfive(five)
                        .qsix(six)
                        .build()
                    Amplify.DataStore.save(edited,
                        { Log.i("Amplify", "Queried item: ") },
                        { Log.e("Amplify", "Queried item failed", it) }
                    )
                } else {

                    val new = QuizResults.builder()
                        .qone(one)
                        .qtwo(two)
                        .qthree(three)
                        .qfour(four)
                        .qfive(five)
                        .qsix(six)
                        .build()
                    Amplify.DataStore.save(
                        new,
                        { success -> Log.i("Amplify", "Updated item: " + success.item().id) },
                        { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
                    )
                }
            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )
    }
}

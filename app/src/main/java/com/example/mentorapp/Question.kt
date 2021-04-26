package com.example.mentorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_questionnaire.*

class Question: AppCompatActivity() {
    private lateinit var one:String
    private lateinit var two:String
    private lateinit var three:String
    private lateinit var four:String
    private lateinit var five:String
    private lateinit var six:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        val answer1: RadioGroup = findViewById(R.id.Question1)
        answer1.setOnCheckedChangeListener{_,checked ->
            if (checked == R.id.Question1A){
                one = "firstyr"
            }
            if (checked == R.id.Question1B){
                one = "secondyr"
            }
            if (checked == R.id.Question1C){
                one = "thirdyr"
            }
        }

        val answer2: RadioGroup = findViewById(R.id.Question2)
        answer2.setOnCheckedChangeListener { _,checked ->
            if (
                checked == R.id.Question2A) {
                two = "firstyr"
            }
            if (checked == R.id.Question2B) {
                two = "secondyr"
            }
        }


        val answer3: Spinner = findViewById(R.id.Question3)
        three = answer3.selectedItem.toString()

        val answer4: Spinner = findViewById(R.id.Question4)
        four = answer4.selectedItem.toString()

        val answer5: RadioGroup = findViewById(R.id.Question5)
        answer5.setOnCheckedChangeListener { _, checked ->
            if (
                checked == R.id.Question5A) {
                five = "inperson"
            }
            if (
                checked == R.id.Question5B) {
                five = "virtual"
            }
            if (
                checked == R.id.Question5C) {
                five = "n/a"
            }
        }

        val answer6: RadioGroup = findViewById(R.id.Question6)
        answer6.setOnCheckedChangeListener { _, checked ->
            if (
                checked == R.id.Question6A) {
                six = "everyday"
            }
            if (
                checked == R.id.Question6B) {
                six = "week"
            }
            if (
                checked == R.id.Question6C) {
                six = "n/a"
            }
        }

        val edit: Button = findViewById(R.id.submit)
        edit.setOnClickListener{
           /* val theAnswer1 = answer1.checkedRadioButtonId
            val theAnswer2 = answer2.checkedRadioButtonId
            val theAnswer3 = answer3.spinner*/
            startActivity(Intent(this, Results::class.java))
        }

    }
    private fun saveAnswers(){
        Question1A
        Question1B
        Question1C

    }
}

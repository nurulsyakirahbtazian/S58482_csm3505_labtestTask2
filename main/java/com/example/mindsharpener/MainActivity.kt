package com.example.mindsharpener

import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var random = Random
    private var num1: Int = 0
    private var num2: Int = 0
    private var operator: String = ""
    private var pointmark: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.level_radio_group)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.level_easy_radio_button -> {
                    num1 = Random.nextInt(10)
                    num2 = Random.nextInt(10)
                }
                R.id.level_medium_radio_button -> {
                    num1 = Random.nextInt(100)
                    num2 = Random.nextInt(100)
                }
                R.id.level_hard_radio_button -> {
                    num1 = Random.nextInt(1000)
                    num2 = Random.nextInt(1000)
                }
            }
            operator = when (Random.nextInt(4)) {
                0 -> "+"
                1 -> "-"
                2 -> "*"
                3 -> "/"
                else -> ""
            }
           // question_text_view.text = "$num1 $operator $num2"
        }
        var check_answer_button = null
        check_answer_button.setOnClickListener {
            val userAnswer = answer_edit_text.text.toString().toInt()
            when (operator) {
                "+" -> {
                    val correctAnswer = num1 + num2
                    if (userAnswer == correctAnswer) {
                        pointmark++
                    } else {
                        pointmark--
                    }
                }
                "-" -> {
                    val correctAnswer = num1 - num2
                    if (userAnswer == correctAnswer) {
                        pointmark++
                    } else {
                        pointmark--
                    }
                }
                "*" -> {
                    val correctAnswer = num1 * num2
                    if (userAnswer == correctAnswer) {
                        pointmark++
                    } else {
                        pointmark--
                    }
                }
                "/" -> {
                    val correctAnswer = num1 / num2
                    if (userAnswer == correctAnswer) {
                        pointmark++
                    } else {
                        pointmark--
                    }
                }
            }
            var pointmark_text_view = null
            pointmark_text_view.text = "pointmark: $pointmark"
        }
    }
}


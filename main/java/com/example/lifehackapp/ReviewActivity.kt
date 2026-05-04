package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

                val layout = findViewById<LinearLayout>(R.id.reviewLayout)

                val questions = arrayOf(
                    "Giving someone a genuine compliment can boost both your mood and theirs",
                    "Laughing can burn calories",
                    "The word 'gullible' isn't in the dictionary",
                    "Writing tasks down improves memory",
                    "Taking 200 selfies to post 1 is considered normal"
                )

                val answers = arrayOf(true, false, false, true, true)

                for (i in questions.indices) {
                    val tv = TextView(this)
                    val answerText = if (answers[i]) "Hack" else "Myth"
                    tv.text = "${questions[i]}\nAnswer: $answerText\n"
                    tv.setPadding(0, 0, 0, 20)
                    layout.addView(tv)
                }
            }
 }

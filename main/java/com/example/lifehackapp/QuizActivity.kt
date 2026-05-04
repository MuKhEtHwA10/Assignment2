package com.example.lifehackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    var index = 0
    var score = 0
    lateinit var questionText: TextView
    lateinit var feedbackText: TextView
    val questions = arrayOf(
        "Giving someone a genuine compliment can boost both your mood and theirs",
        "The word 'gullible' isn't in the dictionary",
        "Laughing cannot burn calories",
        "Writing tasks down improves memory",
        "Taking 200 selfies to post 1 is considered normal"
    )

    val answers = arrayOf(true ,false , false, true, true)
    val explanations = arrayOf(
        "Hack: Giving kindness is contagious.",
        "Myth:But if you checked,I respect your hustle.",
        "Myth: Laughter is a mini workout.",
        "Hack: Writing improves memory.",
        "Hack:The camera roll doesn't lie ."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++

            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
               val intent = Intent(this,ScoreActivity::class.java)
                intent.putExtra("score",score)
                intent.putExtra("total",questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
    }

    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = "Correct! 🎉\n${explanations[index]}"
            score++
        } else {
            feedbackText.text = "Wrong! ❌\n${explanations[index]}"
        }
    }
}



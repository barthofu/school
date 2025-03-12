package dev.bartho.filmquiz

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.bartho.filmquiz.services.QuestionService

class MainActivity : AppCompatActivity() {

    private val questionService = QuestionService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateScore()
        updateQuestion()
    }

    private fun updateScore() {
        val scoreTextView = findViewById<TextView>(R.id.text_score)
        scoreTextView.text = "Score: ${questionService.getScore()}"
    }

    private fun updateQuestion() {
        val nextQuestion = this.questionService.getNextQuestion()

        val questionTextView = findViewById<TextView>(R.id.text_question)
        questionTextView.text = resources.getString(nextQuestion.questionId)
    }

    fun onButtonTrueClicked(view: View) {
        onButtonClicked(true)
    }

    fun onButtonFalseClicked(view: View) {
        onButtonClicked(false)
    }

    // Generic function to handle the button clicks
    private fun onButtonClicked(clickedAnswer: Boolean) {
        val isCorrect = questionService.checkAnswer(clickedAnswer)

        // show the toast notification
        if (isCorrect) {
            println("Correct answer!")
            questionService.updateScore(1)
            Toast.makeText(this, resources.getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, resources.getString(R.string.bad_answer), Toast.LENGTH_SHORT).show()
        }

        // update the ui
        updateScore()
        updateQuestion()
    }

}
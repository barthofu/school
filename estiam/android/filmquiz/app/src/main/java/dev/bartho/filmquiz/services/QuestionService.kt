package dev.bartho.filmquiz.services

import dev.bartho.filmquiz.R
import dev.bartho.filmquiz.models.Question

class QuestionService {

    val questions = listOf(
        Question(R.string.question_1, true),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, true),
        Question(R.string.question_5, true),
    )

    private var currentScore = 0;
    private var currentQuestionIndex = 0;

    fun getNextQuestion(): Question {
        val question = questions[currentQuestionIndex]
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
        return question
    }

    fun getScore(): Int {
        return currentScore
    }

    fun checkAnswer(answer: Boolean): Boolean {
        val correctAnswer = questions[currentQuestionIndex].answer
        return answer == correctAnswer
    }

    fun updateScore(scoreGain: Int) {
        // increment the score attribute
        currentScore += scoreGain
    }

}
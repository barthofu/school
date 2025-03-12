package dev.bartho.filmquiz.models

class Question {
    val questionId: Int
    val answer: Boolean

    constructor(questionId: Int, answer: Boolean) {
        this.questionId = questionId
        this.answer = answer
    }
}
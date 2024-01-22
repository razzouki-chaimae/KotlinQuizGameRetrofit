package com.chaimaerazzouki.quizgame.model

data class QuizResponse(
    val responseCode: Int,
    val results: List<QuestionEntity>
)

package com.chaimaerazzouki.quizgame.data.remote

import com.chaimaerazzouki.quizgame.model.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuizApiService {

    // I got this API from this link : https://rapidapi.com/lewispour1994/api/trivia-quiz-questions-api

    @Headers(
        "X-RapidAPI-Key: d055f74a2cmsh5dd2030efb9ea71p11c973jsnd08c2deb569e",
        "X-RapidAPI-Host: trivia-quiz-questions-api.p.rapidapi.com"
    )
    @GET("/api.php?amount=20&&difficulty=easy&type=multiple&category=23")
    suspend fun getHistoryQuestions(): QuizResponse

    @Headers(
        "X-RapidAPI-Key: d055f74a2cmsh5dd2030efb9ea71p11c973jsnd08c2deb569e",
        "X-RapidAPI-Host: trivia-quiz-questions-api.p.rapidapi.com"
    )
    @GET("/api.php?amount=20&&difficulty=easy&type=multiple&category=22")
    suspend fun getGeographyQuestions(): QuizResponse

    @Headers(
        "X-RapidAPI-Key: d055f74a2cmsh5dd2030efb9ea71p11c973jsnd08c2deb569e",
        "X-RapidAPI-Host: trivia-quiz-questions-api.p.rapidapi.com"
    )
    @GET("/api.php?amount=20&&difficulty=easy&type=multiple&category=21")
    suspend fun getSportsQuestions(): QuizResponse
}
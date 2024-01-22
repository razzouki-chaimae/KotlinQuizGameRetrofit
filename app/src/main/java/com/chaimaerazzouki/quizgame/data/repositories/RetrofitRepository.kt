package com.chaimaerazzouki.quizgame.data.repositories

import android.util.Log
import com.chaimaerazzouki.quizgame.data.remote.QuizApiService
import com.chaimaerazzouki.quizgame.model.QuizResponse

class RetrofitRepository(private val quizApiService: QuizApiService) {

    suspend fun getHistoryQuestions(): QuizResponse{
        return try { quizApiService.getHistoryQuestions() }
                catch (e: Exception) {
                    // TODO : Handle error
                    Log.e("Get History Questions", "Error : $e")
                    QuizResponse(-1, emptyList())
                }
    }

    suspend fun getGeographyQuestions(): QuizResponse {
        return try { quizApiService.getGeographyQuestions() }
                catch (e: Exception) {
                    // TODO : Handle error
                    Log.e("Get Geography Questions", "Error : $e")
                    QuizResponse(-1, emptyList())
                }
    }

    suspend fun getSportsQuestions(): QuizResponse {
        return try { quizApiService.getSportsQuestions() }
                catch (e: Exception) {
                    // TODO : Handle error
                    Log.e("Get Sports Questions", "Error : $e")
                    QuizResponse(-1, emptyList())
                }
    }
}
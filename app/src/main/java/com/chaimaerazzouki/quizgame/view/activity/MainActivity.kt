package com.chaimaerazzouki.quizgame.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.chaimaerazzouki.quizgame.R
import com.chaimaerazzouki.quizgame.data.remote.QuizApiService
import com.chaimaerazzouki.quizgame.viewmodel.NameEntryViewModel
import com.chaimaerazzouki.quizgame.viewmodel.QuizViewModel
import com.chaimaerazzouki.quizgame.viewmodel.ThemeSelectionViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    // Global initialisations
    // Declare the NameEntryViewModel so the player's name can be visible to all the fragments
    val nameEntryViewModel by viewModels<NameEntryViewModel>()
    val themeSelectionViewModel by viewModels<ThemeSelectionViewModel>()
    val quizViewModel by viewModels<QuizViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        // Allow getting notifications
        FirebaseMessaging.getInstance().isAutoInitEnabled = true

        // Initialize Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://trivia-quiz-questions-api.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val quizApiService = retrofit.create(QuizApiService::class.java)

        quizViewModel.setQuizApiService(quizApiService)
    }
}
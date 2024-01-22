package com.chaimaerazzouki.quizgame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chaimaerazzouki.quizgame.data.remote.QuizApiService
import com.chaimaerazzouki.quizgame.data.repositories.RetrofitRepository
import com.chaimaerazzouki.quizgame.model.QuestionEntity
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    // MutableLiveData to hold the questions relative to the selected theme
    private val _themeQuestions = MutableLiveData<List<QuestionEntity>>()
    // MutableLiveData to hold the score of the player
    private val _score = MutableLiveData(0)

    // MutableLiveData to hold the quiz API service
    private val _quizApiService = MutableLiveData<QuizApiService>()


    // Expose an immutable LiveData to observe the questions relative to the selected theme
    val themeQuestions: LiveData<List<QuestionEntity>> get() = _themeQuestions
    // Expose an immutable LiveData to observe the score of the player
    val score: LiveData<Int> get() = _score

    // Expose an immutable LiveData to observe the score of the quiz API service
    val quizApiService: LiveData<QuizApiService> get() = _quizApiService


    // Function to update the questions relative to the selected theme
    private fun setThemeQuestions(themeQuestions : List<QuestionEntity>) {
        _themeQuestions.value = themeQuestions
    }
    // Function to update the score of the player
    fun setScore(score : Int) {
        _score.value = score
    }

    // Function to update the quiz API service
    fun setQuizApiService(quizApiService: QuizApiService) {
        _quizApiService.value = quizApiService
    }

    fun getQuestionsByTheme(theme : String) {
        val retrofitRepository = quizApiService.value?.let { RetrofitRepository(it) }
        when (theme) {
            "History" -> viewModelScope.launch {
                if (retrofitRepository != null) {
                    setThemeQuestions(retrofitRepository.getHistoryQuestions().results)
                }
            }
            "Geography" -> viewModelScope.launch {
                if (retrofitRepository != null) {
                    setThemeQuestions(retrofitRepository.getGeographyQuestions().results)
                }
            }
            "Sport" -> viewModelScope.launch {
                if (retrofitRepository != null) {
                    setThemeQuestions(retrofitRepository.getSportsQuestions().results)
                }
            }
        }
    }

    // reset the data relative to the finished round
    fun reset() {
        setThemeQuestions(emptyList())
        setScore(0)
    }
}
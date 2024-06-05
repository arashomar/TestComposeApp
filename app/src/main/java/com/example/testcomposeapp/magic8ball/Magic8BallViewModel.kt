package com.example.testcomposeapp.magic8ball

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Magic8BallViewModel(
    private val dataRepository: Magic8BallResponsesRepository,
): ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    var response by mutableStateOf("Ask a question")
        private set

    fun generateResponse() {
        viewModelScope.launch {
            isLoading = true
            response = "Thinking..."
            delay(1000)
            response = "Here we go..."
            delay(1000)
            response = dataRepository.getRandomResponse()
            isLoading = false
        }
    }
}
package com.naufal90.aichatapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal90.aichatapp.data.model.Message
import com.naufal90.aichatapp.data.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel(private val repository: ChatRepository) : ViewModel() {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    fun sendMessage(content: String) {
        val userMessage = Message("user", content)
        val currentMessages = _messages.value + userMessage
        _messages.value = currentMessages
        
        viewModelScope.launch {
            _messages.value = repository.sendMessage(currentMessages)
        }
    }
}
package com.naufal90.aichatapp.data.repository

import com.naufal90.aichatapp.data.api.OpenRouterApi
import com.naufal90.aichatapp.data.model.ChatRequest
import com.naufal90.aichatapp.data.model.Message

class ChatRepository(private val api: OpenRouterApi) {
    suspend fun sendMessage(messages: List<Message>): List<Message> {
        val response = api.chat(
            ChatRequest(
                model = "openai/gpt-3.5-turbo",
                messages = messages
            )
        )
        
        return if (response.isSuccessful) {
            messages + response.body()?.choices?.first()?.message!!
        } else {
            messages + Message("assistant", "Error: ${response.message()}")
        }
    }
}

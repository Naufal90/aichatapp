package com.naufal90.aichatapp.data.repository

import com.naufal90.aichatapp.data.api.OpenRouterApi
import com.naufal90.aichatapp.data.model.ChatRequest
import com.naufal90.aichatapp.data.model.Message

class ChatRepository(private val api: OpenRouterApi) {
    suspend fun sendMessage(messages: List<Message>): List<Message> {
        val response = api.chat(
            ChatRequest(
                model = "qwen/qwen3-235b-a22b:free",
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

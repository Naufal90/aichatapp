package com.naufal90.aichatapp.data.api

import com.naufal90.aichatapp.data.model.ChatRequest
import com.naufal90.aichatapp.data.model.ChatResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenRouterApi {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer YOUR_API_KEY" // Ganti dengan API key
    )
    @POST("ai/chat")
    suspend fun chat(@Body request: ChatRequest): Response<ChatResponse>
}
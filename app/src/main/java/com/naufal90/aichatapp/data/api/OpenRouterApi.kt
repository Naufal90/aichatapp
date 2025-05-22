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
        "Authorization: Bearer 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" // Ganti dengan API key
    )
    @POST("ai/chat")
    suspend fun chat(@Body request: ChatRequest): Response<ChatResponse>
}
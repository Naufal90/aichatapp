// app/src/main/java/com/example/aichatapp/utils/ApiFactory.kt
package com.naufal90.aichatapp.utils

import com.naufal90.aichatapp.data.api.OpenRouterApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    fun createOpenRouterApi(): OpenRouterApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        return Retrofit.Builder()
            .baseUrl("https://openrouter.ai/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenRouterApi::class.java)
    }
}
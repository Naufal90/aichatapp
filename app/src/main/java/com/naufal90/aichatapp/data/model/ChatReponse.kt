// ChatResponse.kt
package com.naufal90.aichatapp.data.model

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
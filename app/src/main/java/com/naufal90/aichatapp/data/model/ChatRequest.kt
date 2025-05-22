// ChatRequest.kt
package com.example.aichatapp.data.model

data class ChatRequest(
    val model: String,
    val messages: List<Message>,
    val temperature: Double? = null,
    val max_tokens: Int? = null
)

// Message.kt
package com.example.aichatapp.data.model

data class Message(
    val role: String,
    val content: String
)

// ChatResponse.kt
package com.example.aichatapp.data.model

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
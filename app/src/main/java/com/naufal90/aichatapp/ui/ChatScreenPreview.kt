@Preview(showBackground = true)
@Composable
fun ChatPreview() {
    AIChatAppTheme {
        val dummyMessages = listOf(
            Message("assistant", "Halo! Saya AI asisten. Ada yang bisa saya bantu?", System.currentTimeMillis() - 5000),
            Message("user", "Apa kabar?", System.currentTimeMillis() - 3000),
            Message("assistant", "Saya selalu baik! Bagaimana dengan Anda?", System.currentTimeMillis())
        )
        
        val viewModel = ChatViewModel(ChatRepository(mockApi)).apply {
            _messages.value = dummyMessages
        }
        
        ChatScreen(viewModel)
    }
}
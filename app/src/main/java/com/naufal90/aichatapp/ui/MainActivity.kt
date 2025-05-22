package com.naufal90.aichatapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal90.aichatapp.R
import com.naufal90.aichatapp.data.api.OpenRouterApi
import com.naufal90.aichatapp.data.repository.ChatRepository
import com.naufal90.aichatapp.databinding.ActivityMainBinding
import com.naufal90.aichatapp.ui.adapter.ChatAdapter
import com.naufal90.aichatapp.ui.viewmodel.ChatViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ChatAdapter()
    private val viewModel: ChatViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val api = OpenRouterApi.create() // Anda perlu implementasikan factory untuk OpenRouterApi
                val repository = ChatRepository(api)
                return ChatViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.messages.observe(this) { messages ->
            adapter.submitList(messages)
            binding.recyclerView.scrollToPosition(messages.size - 1)
        }

        binding.sendButton.setOnClickListener {
            val input = binding.inputText.text.toString()
            if (input.isNotBlank()) {
                viewModel.sendMessage(input)
                binding.inputText.text.clear()
            }
        }
    }
}
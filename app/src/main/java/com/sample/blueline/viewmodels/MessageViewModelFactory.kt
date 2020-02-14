package com.sample.blueline.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.blueline.data.MessageRepository

class MessageViewModelFactory(private val repository: MessageRepository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MessageViewModel(repository) as T
    }
}

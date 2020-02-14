package com.sample.blueline.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.sample.blueline.data.MessageRepository
import com.sample.blueline.fragments.CommunicationsFragmentDirections
import com.sample.blueline.handlers.MessageHandler
import com.sample.blueline.models.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository) : ViewModel(), MessageHandler {

    val messages = liveData(Dispatchers.IO) {
        emitSource(repository.getMessages())
    }

    override fun show(view: View, message: Message) {

        viewModelScope.launch {
            repository.updateRead(message.id, true)
        }

        val direction = CommunicationsFragmentDirections
            .actionCommunicationsFragmentToMessageDetailFragment(message)

        view.findNavController().navigate(direction)
    }

    override fun onCleared() {
        super.onCleared()
    }
}
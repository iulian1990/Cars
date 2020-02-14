package com.sample.blueline.utilities

import android.content.Context
import com.sample.blueline.data.MessageRepository
import com.sample.blueline.data.AppDatabase
import com.sample.blueline.viewmodels.MessageViewModelFactory

object InjectorUtils {

    private fun getMessageRepository(context: Context): MessageRepository {
        val dao = AppDatabase.getInstance(context.applicationContext).messageDao()
        return MessageRepository.getInstance(dao)
    }

    fun provideMessageViewModelFactory(context: Context): MessageViewModelFactory {
        val repository = getMessageRepository(context)
        return MessageViewModelFactory(repository)
    }
}
package com.sample.blueline.data

import com.sample.blueline.models.Message
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class MessageRepository private constructor(private val messageDao: MessageDao) {

    suspend fun getMessages() = withContext(IO) {
        messageDao.getMessages()
    }

    suspend fun updateRead(messageId: Int, isRead: Boolean) = withContext(IO) {
        messageDao.updateRead(messageId, isRead)
    }

    companion object {

        @Volatile
        private var INSTANCE: MessageRepository? = null

        fun getInstance(dao: MessageDao): MessageRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MessageRepository(dao).also { INSTANCE = it }
            }
    }
}
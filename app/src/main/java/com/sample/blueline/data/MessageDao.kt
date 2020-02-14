package com.sample.blueline.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sample.blueline.models.Message
import com.sample.musicx.data.BaseDao

@Dao
interface MessageDao : BaseDao<Message> {
    @Query("SELECT * FROM messages")
    fun getMessages(): LiveData<List<Message>>

    @Query("UPDATE messages SET isRead = (:isRead) WHERE id = (:messageId)")
    fun updateRead(messageId: Int, isRead: Boolean)
}


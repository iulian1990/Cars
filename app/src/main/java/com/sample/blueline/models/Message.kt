package com.sample.blueline.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "messages")
data class Message(
    @PrimaryKey val id: Int,
    val title: String,
    val detail: String,
    val date: String,
    var isRead: Boolean = false
) : Parcelable
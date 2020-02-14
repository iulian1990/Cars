package com.sample.blueline.handlers

import android.view.View
import com.sample.blueline.models.Message

interface MessageHandler {
    fun show(view: View, message: Message)
}

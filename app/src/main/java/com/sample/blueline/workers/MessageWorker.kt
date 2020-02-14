package com.sample.blueline.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.sample.blueline.data.AppDatabase
import com.sample.blueline.models.Message
import com.sample.blueline.utilities.MESSAGES_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class MessageWorker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(MESSAGES_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val type = object : TypeToken<List<Message>>() {}.type
                    val albums: List<Message> = Gson().fromJson(jsonReader, type)

                    val db = AppDatabase.getInstance(applicationContext)
                    db.messageDao().insertAll(albums)

                    Result.success()
                }
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }
}

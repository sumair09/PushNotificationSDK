package com.pushnotificationlibrary

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging

object PushNotificationSDK {

    fun initialize(
        context: Context,
        applicationId: String,
        apiKey: String,
        projectId: String,
        onTokenReceived: (String) -> Unit
    ) {
        if (FirebaseApp.getApps(context).isEmpty()) {
            val options = FirebaseOptions.Builder()
                .setApplicationId(applicationId)
                .setApiKey(apiKey)
                .setProjectId(projectId)
                .build()

            FirebaseApp.initializeApp(context, options)
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.e("PushNotificationSDK", "Fetching FCM token failed", task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d("PushNotificationSDK", "FCM Token: $token")
            onTokenReceived(token)
        }
    }
}

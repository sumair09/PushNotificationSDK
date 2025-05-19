package com.pushnotificationlibrary

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging

object PushNotificationSDK {

    fun initialize(context: Context, onTokenReceived: (String) -> Unit) {
        if (FirebaseApp.getApps(context).isEmpty()) {
            val options = FirebaseOptions.Builder()
                .setApplicationId("1:93074134066:android:2a4baddf6c4e6c4659982b") // Replace with actual App ID
                .setApiKey("AIzaSyAAMV2GrsD4ghWK04oqFzgMUClUhHtMUAc")                            // Replace with actual API key
                .setProjectId("push-notification-sdk-c8f7f")                 // Replace with actual Project ID
                .build()

            FirebaseApp.initializeApp(context, options)
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
}
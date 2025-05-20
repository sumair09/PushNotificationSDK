package com.pushnotificationlibrary

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging

object PushNotificationSDK {

    fun initializeFirebase(context: Context, apiKey: String, ) {
        if (FirebaseApp.getApps(context).isEmpty()) {
            val options = FirebaseOptions.Builder()
                .setApplicationId("1:93074134066:android:2a4baddf6c4e6c4659982b")
                .setApiKey(apiKey)
                .setProjectId("push-notification-sdk-c8f7f")
                .setGcmSenderId("93074134066")
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
        }
    }
}

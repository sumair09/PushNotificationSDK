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
                .setApplicationId("1:992052778259:android:490847258e7d584274f6e6")
                .setApiKey(apiKey)
                .setProjectId("itsomni-notification")
                .setGcmSenderId("992052778259")
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

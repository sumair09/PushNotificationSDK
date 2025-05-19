package com.pushnotificationlibrary

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging

object PushNotificationSDK {

    private const val TAG = "PushNotificationSDK"

    fun initialize(context: Context, onTokenReceived: (String) -> Unit) {
        FirebaseApp.initializeApp(context)

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.e(TAG, "Fetching FCM token failed", task.exception)
                return@addOnCompleteListener
            }

            val token = task.result
            Log.d(TAG, "FCM Token: $token")
            onTokenReceived(token)
        }
    }
}

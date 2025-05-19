package com.pushnotificationlibrary

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("PushNotificationSDK", "New token: $token")
        // Optional: Notify server or callback
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("PushNotificationSDK", "Message from: ${remoteMessage.from}")

        remoteMessage.notification?.let {
            Log.d("PushNotificationSDK", "Title: ${it.title}")
            Log.d("PushNotificationSDK", "Body: ${it.body}")
        }
    }
}

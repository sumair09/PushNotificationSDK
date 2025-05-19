package com.pushnotificationlibrary

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

object PushNotificationSDK {

    fun initialize(context: Context) {
        if (FirebaseApp.getApps(context).isEmpty()) {
            val options = FirebaseOptions.Builder()
                .setApplicationId("1:93074134066:android:2a4baddf6c4e6c4659982b") // Replace with actual App ID
                .setApiKey("AIzaSyAAMV2GrsD4ghWK04oqFzgMUClUhHtMUAc")                            // Replace with actual API key
                .setProjectId("push-notification-sdk-c8f7f")                 // Replace with actual Project ID
                .build()

            FirebaseApp.initializeApp(context, options)
        }
    }
}

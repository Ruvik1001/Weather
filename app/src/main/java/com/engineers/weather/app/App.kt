package com.engineers.weather.app

import android.app.Application
import android.util.Log
import com.engineers.weather.di.app.appModule
import com.engineers.weather.di.features.auth.dataAuthModule
import com.engineers.weather.di.features.auth.domainAuthModule
import com.engineers.weather.di.features.viewModelsModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

/**
 * [Application] class for the Questionnaire app.
 *
 * This class is responsible for initializing the application, including setting up Firebase and starting Koin for
 * dependency injection.
 */
class App : Application() {

    /**
     * Called when the application is starting, before any activity, service, or receiver objects (excluding content
     * providers) have been created.
     */
    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase
        FirebaseApp.initializeApp(applicationContext)
        FirebaseApp.getInstance().apply {
            // Check if Firebase API key is missing
            if (options.apiKey.isNullOrEmpty()) {
                throw RuntimeException("Firebase API key is missing. Check your google-services.json file.")
            }
            Log.d("FirebaseApp", "Initialized with API key: ${options.apiKey}")
        }

        // Start Koin for dependency injection
        startKoin {
            androidContext(this@App)
            modules(
                // App-level module
                appModule,

                // Auth modules
                dataAuthModule,
                domainAuthModule,

                // View models module
                viewModelsModule
            )
        }
    }
}

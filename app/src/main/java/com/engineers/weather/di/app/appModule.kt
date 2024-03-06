package com.engineers.weather.di.app

import android.content.Context
import androidx.navigation.NavController
import com.engineers.sign_in.SignInRouter
import com.engineers.weather.glue.auth.AdapterSignInRouter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Koin module for app-level dependencies.
 */
val appModule = module {
    /**
     * Provides an implementation of [SignInRouter] using [AdapterSignInRouter].
     *
     * @param navController The [NavController] used for navigation.
     * @return An instance of [AdapterSignInRouter].
     */
    single<SignInRouter> { AdapterSignInRouter(navController = null) }


}

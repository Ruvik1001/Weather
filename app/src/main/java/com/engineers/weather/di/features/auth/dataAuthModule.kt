package com.engineers.weather.di.features.auth

import com.engineers.data.impl.AuthRepositoryImplData
import com.engineers.domain.auth.AuthRepository
import org.koin.dsl.module

/**
 * Koin module for data layer dependencies related to authentication.
 */
val dataAuthModule = module {
    /**
     * Provides an implementation of [AuthRepository] using [AuthRepositoryImplData].
     *
     * @return An instance of [AuthRepositoryImplData].
     */
    single<AuthRepository> {
        AuthRepositoryImplData()
    }
}

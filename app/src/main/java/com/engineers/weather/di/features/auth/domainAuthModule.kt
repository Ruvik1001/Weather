package com.engineers.weather.di.features.auth

import com.engineers.domain.auth.AuthRepository
import com.engineers.domain.auth.usecase.ResetPasswordUseCase
import com.engineers.domain.auth.usecase.SignInUseCase
import com.engineers.domain.auth.usecase.SignUpUseCase
import com.engineers.domain.auth.usecase.UserLoggedInUseCase
import org.koin.dsl.module

/**
 * Koin module for domain layer dependencies related to authentication.
 */
val domainAuthModule = module {
    /**
     * Provides a [ResetPasswordUseCase] using [ResetPasswordUseCase] implementation with [AuthRepository].
     *
     * @return An instance of [ResetPasswordUseCase].
     */
    factory<ResetPasswordUseCase> {
        ResetPasswordUseCase(get<AuthRepository>())
    }

    /**
     * Provides a [SignInUseCase] using [SignInUseCase] implementation with [AuthRepository].
     *
     * @return An instance of [SignInUseCase].
     */
    factory<SignInUseCase> {
        SignInUseCase(get<AuthRepository>())
    }

    /**
     * Provides a [SignUpUseCase] using [SignUpUseCase] implementation with [AuthRepository].
     *
     * @return An instance of [SignUpUseCase].
     */
    factory<SignUpUseCase> {
        SignUpUseCase(get<AuthRepository>())
    }

    /**
     * Provides a [UserLoggedInUseCase] using [UserLoggedInUseCase] implementation with [AuthRepository].
     *
     * @return An instance of [UserLoggedInUseCase].
     */
    factory<UserLoggedInUseCase> {
        UserLoggedInUseCase(get<AuthRepository>())
    }
}

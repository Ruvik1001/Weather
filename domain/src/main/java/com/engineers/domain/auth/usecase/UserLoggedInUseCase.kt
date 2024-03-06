package com.engineers.domain.auth.usecase

import com.engineers.domain.auth.AuthRepository
import com.google.firebase.auth.FirebaseUser

class UserLoggedInUseCase(private val authRepository: AuthRepository) {

    /**
     * Executes the use case to sign in a user.
     *
     * @param userAuthData The user authentication data containing email and password.
     * @return `true` if the sign-in is successful, `false` otherwise.
     */
    suspend fun execute(): FirebaseUser? = authRepository.userLoggedIn()
}
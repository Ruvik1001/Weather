package com.engineers.sign_in.presentation

import androidx.lifecycle.ViewModel
import com.engineers.domain.auth.data.UserAuthData
import com.engineers.domain.auth.usecase.SignInUseCase
import com.engineers.domain.auth.usecase.UserLoggedInUseCase
import com.engineers.sign_in.SignInRouter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    private val userLoggedInUseCase: UserLoggedInUseCase,
    private val signInRouter: SignInRouter
) : ViewModel() {
    private var user: UserAuthData = UserAuthData("", "")

    init {
        CoroutineScope(Dispatchers.IO).launch {
            if (userLoggedInUseCase.execute() != null)
                lunchProfile()
        }
    }

    /**
     * Sets the user data for sign-in.
     *
     * @param email The user's email.
     * @param password The user's password.
     */
    fun setUserData(email: String, password: String) {
        user.email = email
        user.password = password
    }

    /**
     * Gets the user data for sign-in.
     *
     * @return The user data.
     */
    fun getUserData(): UserAuthData = user

    /**
     * Attempts to sign in the user.
     *
     * @return `true` if sign-in is successful, `false` otherwise.
     */
    suspend fun signIn(): Boolean = signInUseCase.execute(user)

    /**
     * Navigates to the main screen after successful sign-in.
     */
    fun lunchProfile() {
        signInRouter.goToMain()
    }

    /**
     * Navigates to the sign-up screen.
     */
    fun lunchSignUp() {
        signInRouter.goToSignUp()
    }

    /**
     * Navigates to the forgot password screen.
     */
    fun lunchForgotPassword() {
        signInRouter.goToForgotPassword()
    }
}
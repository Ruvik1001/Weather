package com.engineers.sign_in

/**
 * Interface defining navigation actions for the sign-in flow.
 */
interface SignInRouter {
    /**
     * Navigates to the main screen.
     */
    fun goToMain()

    /**
     * Navigates to the sign-up screen.
     */
    fun goToSignUp()

    /**
     * Navigates to the forgot password screen.
     */
    fun goToForgotPassword()
}
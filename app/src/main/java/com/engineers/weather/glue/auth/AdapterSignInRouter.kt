package com.engineers.weather.glue.auth

import android.util.Log
import androidx.navigation.NavController
import com.engineers.sign_in.SignInRouter
import com.engineers.weather.R

/**
 * AdapterSignInRouter is an implementation of [SignInRouter] using NavController for navigation.
 *
 * @param navController The NavController instance for navigation.
 */
class AdapterSignInRouter(
    private var navController: NavController?
) : SignInRouter {

    /**
     * Navigate to the MainFragment.
     */
    override fun goToMain() {
        Log.e("DEBUG", "go to main")
        //navController?.navigate(R.id.action_signInFragment_to_myTestsFragment)
    }

    /**
     * Navigate to the SignUpFragment.
     */
    override fun goToSignUp() {
        navController?.navigate(R.id.action_signInFragment_to_signUpFragment)
    }

    /**
     * Navigate to the ForgotPasswordFragment.
     */
    override fun goToForgotPassword() {
        navController?.navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
    }

    /**
     * Switch the NavController instance.
     *
     * @param navControllerNew The new NavController instance.
     */
    fun switchNavController(navControllerNew: NavController) {
        navController = navControllerNew
    }
}


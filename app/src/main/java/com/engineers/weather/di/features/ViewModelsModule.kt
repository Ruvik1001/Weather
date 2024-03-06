package com.engineers.weather.di.features

import com.engineers.forgot_password.presentation.ForgotPasswordViewModel
import com.engineers.sign_in.presentation.SignInViewModel
import com.engineers.sign_up.presentation.SignUpViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module for providing ViewModel instances for various features.
 */
val viewModelsModule = module {
    /**
     * Provides a [SignInViewModel] using [SignInViewModel] implementation with dependencies.
     *
     * @return An instance of [SignInViewModel].
     */
    viewModel<SignInViewModel> {
        SignInViewModel(
            signInUseCase = get(),
            userLoggedInUseCase = get(),
            signInRouter = get()
        )
    }

    /**
     * Provides a [SignUpViewModel] using [SignUpViewModel] implementation with dependencies.
     *
     * @return An instance of [SignUpViewModel].
     */
    viewModel<SignUpViewModel> {
        SignUpViewModel(
            context = androidContext(),
            signUpUseCase = get()
        )
    }

    /**
     * Provides a [ForgotPasswordViewModel] using [ForgotPasswordViewModel] implementation with dependencies.
     *
     * @return An instance of [ForgotPasswordViewModel].
     */
    viewModel<ForgotPasswordViewModel> {
        ForgotPasswordViewModel(
            context = androidContext(),
            resetPasswordUseCase = get()
        )
    }


}

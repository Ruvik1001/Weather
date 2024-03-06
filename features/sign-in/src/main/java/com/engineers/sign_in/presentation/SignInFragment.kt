package com.engineers.sign_in.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.engineers.sign_in.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {

    private val viewModel by viewModel<SignInViewModel>()
    private lateinit var view: View

    private lateinit var etLogin: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button
    private lateinit var btnForgotPassword: TextView
    private lateinit var progressBar: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        etLogin = view.findViewById(R.id.editTextLogin)
        etPassword = view.findViewById(R.id.editTextPassword)
        btnSignIn = view.findViewById(R.id.btnSignIn)
        btnSignUp = view.findViewById(R.id.btnSignUp)
        btnForgotPassword = view.findViewById(R.id.tvForgotPassword)
        progressBar = view.findViewById(R.id.progress_circular)

        val userData = viewModel.getUserData()
        if (!userData.email.isBlank()) etLogin.setText(userData.email)
        if (!userData.password.isBlank()) etPassword.setText(userData.password)

        btnSignIn.setOnClickListener {
            viewModel.setUserData(etLogin.text.toString(), etPassword.text.toString())
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    progressBar.visibility = ProgressBar.VISIBLE
                    btnSignIn.isClickable = false
                }

                var isSignInSuccessful: Boolean = false
                try {
                    isSignInSuccessful = viewModel.signIn()
                } finally {
                    withContext(Dispatchers.Main) {
                        progressBar.visibility = ProgressBar.GONE
                        btnSignIn.isClickable = true

                        if (isSignInSuccessful) {
                            viewModel.lunchProfile()
                        } else {
                            GlobalScope.launch(Dispatchers.Main) {
                                Toast.makeText(requireContext().applicationContext,
                                    getString(R.string.wrong_login_or_password), Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                }
            }

        }

        btnSignUp.setOnClickListener {
            viewModel.lunchSignUp()
        }

        btnForgotPassword.setOnClickListener {
            viewModel.lunchForgotPassword()
        }

        return view

    }

}
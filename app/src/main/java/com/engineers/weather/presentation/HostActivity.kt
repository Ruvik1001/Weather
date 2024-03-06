package com.engineers.weather.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.engineers.weather.R
import com.engineers.sign_in.SignInRouter
import com.engineers.weather.glue.auth.AdapterSignInRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HostActivity : AppCompatActivity() {
    // Injected dependencies for navigation routers
    private val adapterSignInRouter: SignInRouter by inject()

    /**
     * Called when the activity is first created. Sets up the content view and initializes the navigation.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        CoroutineScope(Dispatchers.Main).launch {
            init()
        }
    }

    /**
     * Initialize the navigation setup.
     */
    private suspend fun init() {
        // Find the NavController associated with the NavHostFragment
        val navController = findNavController(R.id.fragmentContainerView)

        // Switch NavController instances for each router
        (adapterSignInRouter as AdapterSignInRouter).switchNavController(navController)
    }

    /**
     * Handle the back button press. Pop the back stack if available; otherwise, perform the default behavior.
     */
    override fun onBackPressed() {
        if (!findNavController(R.id.fragmentContainerView).popBackStack()) {
            super.onBackPressed()
        }
    }
}
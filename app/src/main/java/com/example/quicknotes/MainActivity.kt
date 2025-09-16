package com.example.quicknotes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.ui.res.painterResource
import com.example.quicknotes.presentation.screens.auth.LoginScreen
import com.example.quicknotes.presentation.screens.auth.LoginViewModel
import com.example.quicknotes.ui.theme.QuickNotesTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels() // 👈 esto estaba faltando
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var googleSignInLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Registrar launcher para recibir el resultado
        googleSignInLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    val idToken = account.idToken
                    if (idToken != null) {
                        loginViewModel.loginWithGoogle(idToken)
                    } else {
                        Log.e("Login", "❌ idToken es null")
                    }
                } catch (e: ApiException) {
                    Log.e("Login", "❌ Google sign-in failed", e)
                }
            }
        }

        setContent {
            QuickNotesTheme {
                LoginScreen(
                    viewModel = loginViewModel,
                    onLoginSuccess = { Log.d("Login", "✅ Usuario logueado con éxito") },
                    onGoogleSignInClicked = {
                        val signInIntent = googleSignInClient.signInIntent
                        googleSignInLauncher.launch(signInIntent)
                    },
                    appIconPainter = painterResource(id = R.drawable.noteicon)
                )
            }
        }
    }
}
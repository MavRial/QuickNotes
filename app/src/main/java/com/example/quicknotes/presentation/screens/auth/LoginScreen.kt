package com.example.quicknotes.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quicknotes.presentation.components.AppButton
import com.example.quicknotes.presentation.components.AppIcon
import com.example.quicknotes.presentation.components.AppText
import com.example.quicknotes.ui.theme.Accent
import com.example.quicknotes.ui.theme.ErrorColor
import com.example.quicknotes.ui.theme.SoftYellow

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit,
    onGoogleSignInClicked: () -> Unit,
    appIconPainter: Painter
) {
    val state = viewModel.uiState.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftYellow)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            LoginUIState.Initial -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    AppIcon(painter = appIconPainter)


                    AppText(
                        text = "Welcome to QuickNotes!",
                        fontSize = 24f,
                        fontWeight = FontWeight.Bold
                    )


                    AppButton(
                        text = "Login with Google",
                        onClick = onGoogleSignInClicked,
                        widthFraction = 0.8f,
                        height = 50.dp,
                        fontSize = 16f,
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }

            LoginUIState.Loading -> {
                CircularProgressIndicator(color = Accent)
            }

            is LoginUIState.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AppText(
                        text = "Error: ${state.message}",
                        fontSize = 16f,
                        color = ErrorColor
                    )

                    AppButton(
                        text = "Retry",
                        onClick = { viewModel.reset() },
                        widthFraction = 0.5f
                    )
                }
            }

            LoginUIState.LoggedIn -> onLoginSuccess()
        }
    }
}

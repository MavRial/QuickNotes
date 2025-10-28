package com.example.quicknotes.presentation.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quicknotes.R
import com.example.quicknotes.presentation.screens.auth.LoginScreen
import com.example.quicknotes.presentation.screens.auth.LoginViewModel
import com.example.quicknotes.presentation.screens.home.NotesScreen
import com.example.quicknotes.ui.theme.QuickNotesTheme

@Composable
fun NavigationWrapper(
    onGoogleSignInClicked: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(
                viewModel = loginViewModel,
                onLoginSuccess = { navController.navigate(Screen.Notes.route) },
                onGoogleSignInClicked = onGoogleSignInClicked,
                appIconPainter = painterResource(id = R.drawable.noteicon)
            )
        }

        composable(Screen.Notes.route) {
            NotesScreen(

            )
        }

    }
}
package devel.some.memories.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import devel.some.memories.echos.presentation.create_echo.CreateEchoRoot
import devel.some.memories.echos.presentation.echos.EchosRoot
import devel.some.memories.echos.presentation.settings.SettingsRoot

const val ACTION_CREATE_ECHO = "devel.some.CREATE_ECHO"

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Echos(
            startRecording = false
        )
    ) {
        composable<NavigationRoute.Echos>(
            deepLinks = listOf(
                navDeepLink<NavigationRoute.Echos>(
                    basePath = "https://memoriesinvoice.com/echos"
                ) {
                    action = ACTION_CREATE_ECHO
                }
            )
        ) {
            EchosRoot(
                onNavigateToCreateEcho = { details ->
                    navController.navigate(details.toCreateEchoRoute())
                },
                onNavigateToSettings = {
                    navController.navigate(NavigationRoute.Settings)
                }
            )
        }
        composable<NavigationRoute.CreateEcho> {
            CreateEchoRoot(
                onConfirmLeave = navController::navigateUp
            )
        }
        composable<NavigationRoute.Settings> {
            SettingsRoot(
                onGoBack = navController::navigateUp
            )
        }
    }
}
package dev.syprosegwako.littlelemon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.syprosegwako.littlelemon.utils.PreferencesManager

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier){

    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    preferencesManager.clearAllData()

    val firstname = preferencesManager.getData("FIRST_NAME", "")
    val startDestination = if(firstname.isBlank()) Onboarding.route else Home.route

    NavHost(navController = navController, startDestination = startDestination ) {
        composable(Onboarding.route){
            Onboarding(navController)
        }

        composable(Home.route){
            Home(navController)
        }

        composable(Profile.route){
            Profile(navController)
        }

    }
}
package ir.schooltech.alghadirsmsnotification.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.schooltech.alghadirsmsnotification.screens.main.MainScreen
import ir.schooltech.alghadirsmsnotification.screens.main.MainViewModel
import ir.schooltech.alghadirsmsnotification.screens.message.MessageScreen

@Composable
fun AlghadirSmsAppNavigation(widthSizeClass:WindowWidthSizeClass){
	val navController= rememberNavController()
	NavHost(navController = navController, startDestination = AppScreens.MainScreen.name){
		composable(route = AppScreens.MainScreen.name){
			val mainViewModel = hiltViewModel<MainViewModel>()
			
			MainScreen(
				navController = navController,
				widthSize = widthSizeClass,
				onExploreItemClicked = {
				
				},
				onDateSelectionClicked = {
				
				},
				mainViewModel = mainViewModel
			)
		}
		
		composable(route=AppScreens.MessageScreen.name){
			MessageScreen(navController = navController)
		}
	}
}
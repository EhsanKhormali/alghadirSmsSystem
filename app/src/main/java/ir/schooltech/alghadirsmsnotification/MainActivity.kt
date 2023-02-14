package ir.schooltech.alghadirsmsnotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ir.schooltech.alghadirsmsnotification.navigation.AlghadirSmsAppNavigation
import ir.schooltech.alghadirsmsnotification.ui.theme.AlghadirSMSNotificationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		//WindowCompat.setDecorFitsSystemWindows(window, false)
		
		setContent {
			AlghadirSMSNotificationTheme {
				val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
				AlghadirSmsApp(widthSizeClass)
			}
		}
	}
}

@Composable
fun AlghadirSmsApp(widthSizeClass:WindowWidthSizeClass){
	// A surface container using the 'background' color from the theme
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.background
	) {
		AlghadirSmsAppNavigation(widthSizeClass)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	AlghadirSMSNotificationTheme {
	
	}
}
package ir.schooltech.alghadirsmsnotification.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ir.schooltech.alghadirsmsnotification.R
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onTimeout: () -> Unit) {
	// Adds composition consistency. Use the value when LaunchedEffect is first called
	val currentOnTimeout by rememberUpdatedState(onTimeout)
	
	LaunchedEffect(Unit) {
		delay(SplashWaitTime)
		currentOnTimeout()
	}
	Image(
		painterResource(id = R.drawable.ic_logo),
		contentDescription = null,
		modifier
			.fillMaxSize()
			.wrapContentSize()
	)
}
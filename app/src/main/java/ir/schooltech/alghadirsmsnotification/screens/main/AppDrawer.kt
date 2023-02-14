package ir.schooltech.alghadirsmsnotification.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val drawerItems = listOf(
	"Account",
	"Trip",
	"Hello"
)

@Preview
@Composable
fun AppDrawer(modifier: Modifier=Modifier){
	Column(
		modifier
			.fillMaxSize()
			.padding(start = 24.dp, top = 48.dp)
	) {
		Image(imageVector = Icons.Default.AccountBox, contentDescription = "")
		for (screenTitleResource in drawerItems) {
			Spacer(Modifier.height(24.dp))
			Text(
				text = screenTitleResource,
				style = MaterialTheme.typography.h4
			)
		}
	}
}
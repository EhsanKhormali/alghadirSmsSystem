package ir.schooltech.alghadirsmsnotification.screens.message

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.schooltech.alghadirsmsnotification.widgets.AppBar

@Composable
fun MessageScreen(navController: NavController) {
	val messageValueState = rememberSaveable() { mutableStateOf("") }
	Scaffold(topBar = {
		AppBar(
			navController = navController,
		)
	}) {
		
		Column(modifier = Modifier
			.padding(4.dp)
			.padding(it)) {
			Text(text = "Message")
			OutlinedTextField(
				value = messageValueState.value,
				onValueChange = {
					messageValueState.value = it
				},
				singleLine = false,
				maxLines = Int.MAX_VALUE,
				modifier = Modifier
					.fillMaxWidth()
					.padding(4.dp)
					.height(TextFieldDefaults.MinHeight * 4),
				
				)
			Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
				
				Button(onClick = { /*TODO*/ }) {
					Text(text = "send message")
				}
			}
		}
	}
	
}
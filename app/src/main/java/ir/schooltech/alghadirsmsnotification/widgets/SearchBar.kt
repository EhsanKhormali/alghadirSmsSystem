package ir.schooltech.alghadirsmsnotification.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
	modifier: Modifier,
	onMenuClicked: () -> Unit,
	onSearchKeyChanged: (String) -> Unit
) {
	val keyboardController = LocalSoftwareKeyboardController.current
	val searchQueryState = rememberSaveable() { mutableStateOf("") }
	Row(
		modifier = Modifier.padding(top = 8.dp),
		horizontalArrangement = Arrangement.End
	) {
		Image(
			modifier = Modifier
				.padding(8.dp)
				.clickable(onClick = onMenuClicked),
			imageVector = Icons.Default.Menu,
			contentDescription = "menu Icon"
		)
		
		Spacer(Modifier.width(8.dp))
		OutlinedTextField(
			modifier = Modifier.weight(1f),
			value = searchQueryState.value,
			onValueChange = {
				searchQueryState.value=it
				onSearchKeyChanged(it)
			},
			leadingIcon = {
				Icon(
					imageVector = Icons.Default.Search,
					contentDescription = "Search icon"
				)
			},
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Text,
				imeAction = ImeAction.Search
			),
			keyboardActions = KeyboardActions{
											 keyboardController?.hide()
			},
			maxLines = 1,
			singleLine = true
		)
		
		IconButton(onClick = { /*TODO*/ }) {
			Icon(imageVector = Icons.Default.MoreVert, contentDescription = "action")
		}
	}
	
}

package ir.schooltech.alghadirsmsnotification.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ir.schooltech.alghadirsmsnotification.R

@Composable
fun AppBar(
	modifier:Modifier=Modifier,
	navController: NavController,
	backgroundColor:Color=Color.White,
){
		TopAppBar(
			navigationIcon = {
							 Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
			},
			title = {
				Row {
					Text(text = "Title")
				}
			},
			backgroundColor = backgroundColor,
			actions = {
				CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
						Icon(
							imageVector = Icons.Default.MoreVert,
							contentDescription = stringResource(R.string.cd_search)
						)
				}
			},
			modifier = modifier
		)
}
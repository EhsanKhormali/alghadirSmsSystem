package ir.schooltech.alghadirsmsnotification.screens.main

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.schooltech.alghadirsmsnotification.model.StudentsClass
import ir.schooltech.alghadirsmsnotification.navigation.AppScreens
import ir.schooltech.alghadirsmsnotification.screens.splash.SplashScreen
import ir.schooltech.alghadirsmsnotification.screens.splash.SplashState
import ir.schooltech.alghadirsmsnotification.widgets.AppBar
import ir.schooltech.alghadirsmsnotification.widgets.SearchBar
import kotlinx.coroutines.launch

typealias OnExploreItemClicked = (StudentsClass) -> Unit

enum class CraneScreen {
	Fly, Sleep, Eat
}


@Composable
fun MainScreen(
	navController: NavController,
	widthSize: WindowWidthSizeClass,
	onExploreItemClicked: OnExploreItemClicked,
	onDateSelectionClicked: () -> Unit,
	mainViewModel: MainViewModel
) {
	Surface(
		modifier = Modifier.windowInsetsPadding(
			WindowInsets.navigationBars.only(WindowInsetsSides.Start + WindowInsetsSides.End)
		),
		color = MaterialTheme.colors.primary
	) {
		val transitionState = remember { MutableTransitionState(mainViewModel.shownSplash.value) }
		val transition = updateTransition(transitionState, label = "splashTransition")
		val splashAlpha by transition.animateFloat(
			transitionSpec = { tween(durationMillis = 100) }, label = "splashAlpha"
		) {
			if (it == SplashState.Shown) 1f else 0f
		}
		val contentAlpha by transition.animateFloat(
			transitionSpec = { tween(durationMillis = 300) }, label = "contentAlpha"
		) {
			if (it == SplashState.Shown) 0f else 1f
		}
		val contentTopPadding by transition.animateDp(
			transitionSpec = { spring(stiffness = Spring.StiffnessLow) },
			label = "contentTopPadding"
		) {
			if (it == SplashState.Shown) 100.dp else 0.dp
		}
		
		Box {
			SplashScreen(
				modifier = Modifier.alpha(splashAlpha),
				onTimeout = {
					transitionState.targetState = SplashState.Completed
					mainViewModel.shownSplash.value = SplashState.Completed
				}
			)
			
			MainContent(
				modifier = Modifier.alpha(contentAlpha),
				navController = navController,
				topPadding = contentTopPadding,
				onExploreItemClicked = onExploreItemClicked,
				onDateSelectionClicked = onDateSelectionClicked,
				viewModel = mainViewModel
			)
		}
	}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MainContent(
	modifier: Modifier = Modifier,
	topPadding: Dp = 0.dp,
	onExploreItemClicked: OnExploreItemClicked,
	onDateSelectionClicked: () -> Unit,
	viewModel: MainViewModel,
	navController: NavController
) {
	
	Column(modifier = modifier) {
		Spacer(Modifier.padding(top = topPadding))
		val scaffoldState = rememberScaffoldState()
		Scaffold(
			modifier = Modifier.statusBarsPadding(),
			scaffoldState = scaffoldState,
			drawerContent = {
				AppDrawer()
			},
			floatingActionButton = {
				FloatingActionButton(
					shape = RoundedCornerShape(10.dp),
					//contentColor = MaterialTheme.colors.onPrimary,
					onClick = { navController.navigate(AppScreens.MessageScreen.name) }
				) {
					Icon(
						modifier = Modifier
							.padding(4.dp)
							.requiredSize(25.dp),
						imageVector = Icons.Default.ArrowForward,
						contentDescription = "compose message"
					)
				}
			}
		) {
			val scope = rememberCoroutineScope()
			BackdropScaffold(
				modifier = modifier.padding(it),
				scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
				peekHeight = 70.dp,
				frontLayerShape = RoundedCornerShape(
					topStart = 20.dp,
					topEnd = 20.dp,
					bottomStart = 0.dp,
					bottomEnd = 0.dp
				),
				frontLayerScrimColor = Color.Unspecified,
				appBar = {
					SearchBar(modifier = modifier,
						onSearchKeyChanged = {},
						onMenuClicked = {
							scope.launch {
								scaffoldState.drawerState.open()
							}
						})
				},
				backLayerContent = {
					GroupsSection()
				},
				frontLayerContent = {
					StudentList(onItemClicked = {})
				}
			) {
			
			}
		}
	}
}

@Composable
fun StudentList(onItemClicked: (String) ->Unit) {
	Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
		val studentList= listOf("ali","hasan","hosein","taghi","ehsan","mohsen","hanif")
		Column(modifier = Modifier.padding(start = 24.dp, top = 20.dp, end = 24.dp)) {
			Text(
				text = "list of students",
				style = MaterialTheme.typography.caption
			)
			Spacer(Modifier.height(8.dp))
			
			LazyColumn(){
				items(studentList){
					val (checkedState, onStateChange) = remember { mutableStateOf(true) }
					Row(Modifier
						.fillMaxWidth()
						.height(56.dp)
						.toggleable(
							value = checkedState,
							onValueChange = { onStateChange(!checkedState) },
							role = Role.Checkbox),
						verticalAlignment = Alignment.CenterVertically){
						Card(modifier = Modifier
							.height(55.dp)
							.fillMaxWidth()
							.padding(4.dp)) {
							Row(verticalAlignment = Alignment.CenterVertically) {
								Checkbox(
									checked = checkedState,
									onCheckedChange = null // null recommended for accessibility with screenreaders
								)
								Text(
									text = it,
									style = MaterialTheme.typography.body2,
									modifier = Modifier.padding(start = 16.dp)
								)
							}
						}
					}
					
					
				}
			}
			
		}
	}
}

@Composable
fun GroupsSection() {
	Column(
		Modifier.padding(start = 8.dp, top = 16.dp)
	) {
		Text(text = "Groups")
		LazyRow {
			items(
				items = listOf("101", "102", "103", "201", "202", "203", "301", "302", "303")
			) {
				Card(
					modifier = Modifier
						.size(100.dp)
						.padding(8.dp),
					shape = RoundedCornerShape(5.dp)
				) {
					Column(
						verticalArrangement = Arrangement.Center,
						horizontalAlignment = Alignment.CenterHorizontally
					) {
						Text(text = it)
					}
					
				}
			}
		}
	}
}

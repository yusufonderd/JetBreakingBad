package com.yonder.breakingbadcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import com.yonder.breakingbadcompose.ui.characters.Characters
import com.yonder.breakingbadcompose.ui.quotes.Quotes
import com.yonder.breakingbadcompose.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BreakingBadTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = stringResource(id = R.string.app_name))
                            })
                        },
                        bottomBar = {
                            BottomNavigation {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute =
                                    navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                                items.forEach { screen ->
                                    BottomNavigationItem(
                                        icon = {
                                            Icon(
                                                imageVector = screen.icon,
                                                contentDescription = null,
                                            )
                                        },
                                        label = { Text(stringResource(screen.resourceId)) },
                                        selected = currentRoute == screen.route,
                                        onClick = {
                                            navController.navigate(screen.route) {
                                                // Pop up to the start destination of the graph to
                                                // avoid building up a large stack of destinations
                                                // on the back stack as users select items
                                                popUpTo = navController.graph.startDestination
                                                // Avoid multiple copies of the same destination when
                                                // reselecting the same item
                                                launchSingleTop = true
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) {
                        NavHost(navController, startDestination = Screen.Characters.route) {
                            composable(Screen.Characters.route) { Characters(navController) }
                            composable(Screen.Quotes.route) { Quotes(navController) }
                        }
                    }

                }
            }
        }
    }
}


val items = listOf(
    Screen.Characters,
    Screen.Quotes,
)

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Characters : Screen("characters", R.string.characters, Icons.Filled.Star)
    object Quotes : Screen("quotes", R.string.quotes, Icons.Filled.List)
}




package com.yonder.breakingbadcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import com.yonder.breakingbadcompose.ui.characters.Characters
import com.yonder.breakingbadcompose.ui.quotes.Quotes
import com.yonder.breakingbadcompose.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint

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
                        bottomBar = {
                            BottomNavigation {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute =
                                    navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                                items.forEach { screen ->
                                    BottomNavigationItem(
                                        icon = { Icons.Filled.Favorite },
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

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Characters : Screen("characters", R.string.characters)
    object Quotes : Screen("quotes", R.string.quotes)
}




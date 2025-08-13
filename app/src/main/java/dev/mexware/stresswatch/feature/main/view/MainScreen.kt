package dev.mexware.stresswatch.feature.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.mexware.stresswatch.R
import dev.mexware.stresswatch.components.MainBottomBar
import dev.mexware.stresswatch.feature.main.model.MainDestination
import dev.mexware.stresswatch.feature.auth.view.components.RegisterLogoHeader
import dev.mexware.stresswatch.ui.theme.StressDarkBlue

// Home real
import dev.mexware.stresswatch.feature.home.view.HomeScreen
// Chat real
import dev.mexware.stresswatch.feature.chat.view.ChatScreen
// Sensors dashboard real
import dev.mexware.stresswatch.feature.sensors.view.SensorsDashboardScreen
import dev.mexware.stresswatch.feature.sensors.model.SensorType
// Detalle de sensor (única pantalla parametrizada)
import dev.mexware.stresswatch.feature.sensors.view.detail.SensorDetailScreen

@Composable
fun MainScreen() {
    val nav = rememberNavController()
    val currentRoute = nav.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        containerColor = StressDarkBlue,
        contentColor = Color.White,
        topBar = { RegisterLogoHeader(logoRes = R.drawable.logo_stress) },
        bottomBar = {
            MainBottomBar(
                currentRoute = currentRoute,
                onSelect = { dest ->
                    nav.navigate(dest.route) {
                        popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = nav,
                startDestination = MainDestination.HOME.route
            ) {
                composable(MainDestination.HOME.route) {
                    HomeScreen()
                }
                composable(MainDestination.CHAT.route) {
                    ChatScreen()
                }
                // Dashboard de sensores
                composable(MainDestination.SENSORS.route) {
                    SensorsDashboardScreen(
                        onOpen = { type: SensorType ->
                            nav.navigate("sensors_detail/${type.name}")
                        }
                    )
                }
                // Detalle de sensor (única pantalla para STRESS/SLEEP/MOOD)
                composable(
                    route = "sensors_detail/{type}",
                    arguments = listOf(navArgument("type") { type = NavType.StringType })
                ) { backStack ->
                    val typeArg = backStack.arguments!!.getString("type")!!
                    val type = SensorType.valueOf(typeArg)
                    SensorDetailScreen(type = type)
                }
            }
        }
    }
}

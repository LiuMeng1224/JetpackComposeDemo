package com.example.jetpack_compose_demo1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


object MainDestination {
    const val MAIN_ROUTE = "MainPage"
    const val LIVE_STREAMING_LIST_ROUTE = "LiveStreamingList"
    const val LIVE_STREAMING_DETAIL = "LiveStreamingDetail"
    const val LIVE_STREAMING_ID_KEY = "LiveStreamingId"
}

@Composable
fun rememberAppNavigationController(navController:NavHostController = rememberNavController() ) : AppNavigationController = remember(navController)  {
    AppNavigationController(navController = navController)
}

@Stable
class AppNavigationController(val navController:NavHostController) {

    val currentRoute:String? get() = navController.currentDestination?.route

    fun pop() {
        navController.navigateUp()
    }

    fun navigateToMainPage(route:String) {
        navController.popBackStack(route, inclusive = false)
    }

    fun navigateToLiveStreamingListPage(from: NavBackStackEntry) {
        if(from.lifecycleIsResumed()) {
            navController.navigate(MainDestination.LIVE_STREAMING_LIST_ROUTE)
        }
    }

    fun navigateToLiveStreamingDetailPage(id : String, from: NavBackStackEntry) {
        if(from.lifecycleIsResumed()) {
            navController.navigate("${MainDestination.LIVE_STREAMING_DETAIL}/$id")
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}
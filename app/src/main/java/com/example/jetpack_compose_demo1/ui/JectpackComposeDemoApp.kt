package com.example.jetpack_compose_demo1.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpack_compose_demo1.ui.home.MainPage
import com.example.jetpack_compose_demo1.ui.live.LiveStreamingDetail
import com.example.jetpack_compose_demo1.ui.live.LiveStreamingList
import com.example.jetpack_compose_demo1.ui.navigation.MainDestination
import com.example.jetpack_compose_demo1.ui.navigation.rememberAppNavigationController
import com.example.jetpack_compose_demo1.ui.theme.Jetpack_compose_demo1Theme

@Composable
fun jetpackComposeDemoApp() {
    Jetpack_compose_demo1Theme {
        val navigationController = rememberAppNavigationController()
        NavHost(
            navController = navigationController.navController,
            startDestination = MainDestination.MAIN_ROUTE
        ) {
            demoAppNavGraph(
                onNavigateMain = navigationController::navigateToMainPage,
                onClickLeftArrow = navigationController::pop,
                onNavigateMoreLiveStreaming = navigationController::navigateToLiveStreamingListPage,
                onNavigateLiveStreamingDetail = navigationController::navigateToLiveStreamingDetailPage
            )
        }
    }

}


private fun NavGraphBuilder.demoAppNavGraph(
    onNavigateMain: (String) -> Unit,
    onClickLeftArrow: () -> Unit,
    onNavigateMoreLiveStreaming: (NavBackStackEntry) -> Unit,
    onNavigateLiveStreamingDetail: (String, NavBackStackEntry) -> Unit
) {
    composable(MainDestination.MAIN_ROUTE) {
        MainPage(onClickLeftArrow, onNavigateMoreLiveStreaming, onNavigateLiveStreamingDetail)
    }
    composable(
        MainDestination.LIVE_STREAMING_LIST_ROUTE
    ) {from ->
        LiveStreamingList(
            onClickLeftArrow = onClickLeftArrow,
            onNavigateLiveStreamingDetail = { id -> onNavigateLiveStreamingDetail(id, from) }
        )
    }

    composable(
        "${MainDestination.LIVE_STREAMING_DETAIL}/{${MainDestination.LIVE_STREAMING_ID_KEY}}",
        arguments = listOf(navArgument(MainDestination.LIVE_STREAMING_ID_KEY) { type = NavType.StringType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val liveStreamingId = arguments.getString(MainDestination.LIVE_STREAMING_ID_KEY)
        if (liveStreamingId != null) {
            LiveStreamingDetail(id = liveStreamingId, onNavigateMain, onClickLeftArrow)
        }
    }
}


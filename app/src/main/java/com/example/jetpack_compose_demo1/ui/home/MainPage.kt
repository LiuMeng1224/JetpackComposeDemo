package com.example.jetpack_compose_demo1.ui.home

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_demo1.R
import com.example.jetpack_compose_demo1.model.DemoData
import com.example.jetpack_compose_demo1.model.MainTabBarItem
import com.example.jetpack_compose_demo1.ui.components.Concentration
import com.example.jetpack_compose_demo1.ui.components.NationalBoutique
import com.example.jetpack_compose_demo1.ui.theme.black333
import com.example.jetpack_compose_demo1.ui.theme.green00cc7e
import com.example.jetpack_compose_demo1.ui.theme.grey444

@Composable
fun MainPage(
    onClickLeftArrow: () -> Unit,
    onNavigateMoreLiveStreaming: (NavBackStackEntry) -> Unit,
    onNavigateLiveStreamingDetail: (String, NavBackStackEntry) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        val tabBarList = remember { DemoData.getMainTabBarList() }
        val categories = remember { DemoData.getCategoryList() }
        val bannerImages = remember { DemoData.getBannerImageList() }
        val liveStreamings = remember { DemoData.getLiveStreamingList() }
        Column {
            HeaderSearchView()
            MainTopTabBar(tabBarList, onClickItem = {
                navController.navigate(it)
            })
            NavHost(
                navController = navController,
                startDestination = "MainPage_index0",
                enterTransition = {
                    slideInVertically(
                        initialOffsetY = { 0 },
                        animationSpec = tween(700)
                    )
                },
                exitTransition = {
                    slideOutVertically(
                        targetOffsetY = { 1000 },
                        animationSpec = tween(700)
                    )
                }
            ) {
                tabBarList.forEach { item ->
                    if (item.path == "MainPage_index0") composable(
                        route = item.path,
                    ) {from ->
                        Concentration(
                            categoryList = categories,
                            bannerImages = bannerImages,
                            liveStreamingList = liveStreamings,
                            onNavigateMoreLiveStreaming = { onNavigateMoreLiveStreaming(from) },
                            onNavigateLiveStreamingDetail = { id ->  onNavigateLiveStreamingDetail(id, from) }
                        )
                    } else composable(item.path) {
                        NationalBoutique(item.title)
                    }
                }
            }
        }
    }


}


@Composable
fun HeaderSearchView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.mipmap.logo_image),
            contentDescription = "logo_image",
            modifier = Modifier
                .width(166.dp)
                .height(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "打开APP",
            style = TextStyle(color = green00cc7e, fontSize = 13.sp),
            modifier = Modifier
                .clickable {
                    Log.e("clickable", "----打开App")
                }
                .drawBehind {
                    drawRoundRect(
                        green00cc7e,
                        cornerRadius = CornerRadius(12.dp.toPx()),
                        style = Stroke(width = 1.dp.toPx())
                    )
                }
                .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)

        )
        Spacer(modifier = Modifier.weight(weight = 1.0f))
        Icon(
            Icons.Rounded.Search,
            contentDescription = "Search",
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clickable {
                    Log.e("clickable", "----搜索")
                }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "登录",
            style = TextStyle(color = black333, fontSize = 14.sp),
            modifier = Modifier
                .padding(end = 2.dp)
                .clickable {
                    Log.e("clickable", "----登录")
                })
        Text(text = "|", style = TextStyle(color = black333, fontSize = 16.sp))
        Text(
            text = "注册",
            style = TextStyle(color = black333, fontSize = 14.sp),
            modifier = Modifier
                .padding(end = 2.dp)
                .clickable {
                    Log.e("clickable", "----注册")
                })
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun MainTopTabBar(tabBarList: List<MainTabBarItem>, onClickItem: (String) -> Unit) {
    var selectedTitle by rememberSaveable { mutableStateOf("精选") }
    Row {
        LazyRow(
            modifier = Modifier
                .height(39.dp)
                .weight(1.0f)
        ) {
            items(tabBarList, key = { it }) { item ->
                NavigationItem(item.title, selectedTitle, onClickItem = {
                    selectedTitle = it
                    onClickItem(item.path)
                })
            }
        }
        Box(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .clickable {
                    Log.e("clickable", "----Menu")
                }
        ) {
            Icon(
                Icons.Rounded.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .width(20.dp)
                    .height(15.dp)
            )
        }
    }

}

@Composable
fun NavigationItem(navigationTitle: String, selectedTitle: String, onClickItem: (String) -> Unit) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .height(39.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = navigationTitle,
            style = TextStyle(
                fontSize = 16.sp,
                color = if (navigationTitle == selectedTitle) green00cc7e else grey444
            ),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    onClickItem(navigationTitle)
                }
        )
        Spacer(modifier = Modifier.height(5.dp))
        if (navigationTitle == selectedTitle) {
            Text(
                text = "",
                modifier = Modifier
                    .width(20.dp)
                    .height(4.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = green00cc7e,
                            cornerRadius = CornerRadius(2.dp.toPx()),
                        )
                    }
            )
        }
    }
}
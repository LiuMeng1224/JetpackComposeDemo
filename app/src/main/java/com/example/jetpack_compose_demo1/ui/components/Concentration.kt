package com.example.jetpack_compose_demo1.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetpack_compose_demo1.model.CategoryItem
import com.example.jetpack_compose_demo1.model.LiveStreaming
import com.example.jetpack_compose_demo1.ui.theme.black333
import com.example.jetpack_compose_demo1.ui.theme.green00cc7e
import com.example.jetpack_compose_demo1.ui.theme.grey999
import com.example.jetpack_compose_demo1.ui.theme.greyE6
import com.example.jetpack_compose_demo1.ui.theme.greyEE
import com.example.jetpack_compose_demo1.ui.theme.white


@Composable
fun Concentration(
    categoryList: List<CategoryItem>,
    bannerImages: List<String>,
    liveStreamingList: List<LiveStreaming>,
    onNavigateMoreLiveStreaming: () -> Unit,
    onNavigateLiveStreamingDetail: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(greyEE)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
    ) {
        CourseCategoryGrid(categoryList = categoryList)
        Spacer(modifier = Modifier.height(10.dp))
        LatestCourses(bannerImages = bannerImages)
        Spacer(modifier = Modifier.height(10.dp))
        RecentlyLiveStreamingList(liveStreamingList, onNavigateMoreLiveStreaming, onNavigateLiveStreamingDetail)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseCategoryGrid(categoryList: List<CategoryItem>) {
    val verticalGridList =
        listOf(categoryList.subList(0, 10), categoryList.subList(10, categoryList.size))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val pagerState = rememberPagerState(pageCount = {
            verticalGridList.size
        })
        Box(
            modifier = Modifier
                .weight(1.0f)
                .height(190.dp)
                .drawBehind {
                    drawRoundRect(color = white, cornerRadius = CornerRadius(12.dp.toPx()))
                }
        ) {
            HorizontalPager(state = pagerState) { page ->
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .fillMaxHeight(),
                    columns = GridCells.Fixed(5),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(verticalGridList[page]) { categories ->
                        CategoryItem(categories)
                    }
                }
            }
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = "",
                        modifier = Modifier
                            .width(if (pagerState.currentPage == 0) 14.dp else 6.dp)
                            .height(2.dp)
                            .drawBehind {
                                drawRoundRect(
                                    color = if (pagerState.currentPage == 0) green00cc7e else greyE6,
                                    cornerRadius = CornerRadius(2.5.dp.toPx()),
                                )
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "",
                        modifier = Modifier
                            .width(if (pagerState.currentPage == 1) 14.dp else 6.dp)
                            .height(2.dp)
                            .drawBehind {
                                drawRoundRect(
                                    color = if (pagerState.currentPage == 1) green00cc7e else greyE6,
                                    cornerRadius = CornerRadius(2.5.dp.toPx()),
                                )
                            }
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }

}

@Composable
fun CategoryItem(category: CategoryItem) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = category.categoryImg,
            contentDescription = "category image",
            modifier = Modifier
                .width(52.dp)
                .height(52.dp)
        )
        Text(
            text = category.categoryName,
            style = TextStyle(fontSize = 12.sp, color = black333)
        )
    }
}

@Composable
fun LatestCourses(bannerImages: List<String>) {
    Row(
        modifier = Modifier
            .height(115.dp)
    ) {
        Banner(
            images = bannerImages, modifier = Modifier
                .weight(2.0f)
                .height(115.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        AsyncImage(
            model = "https://edu-image.nosdn.127.net/b37bfbaddb844eadb454fe1975c8760c.png?imageView&quality=100&thumbnail=312y312",
            contentDescription = "",
            modifier = Modifier
                .weight(1.0f)
                .height(115.dp)
        )
    }
}

@Composable
fun RecentlyLiveStreamingList(
    liveStreamingList: List<LiveStreaming>,
    onNavigateMoreLiveStreaming: () -> Unit,
    onNavigateLiveStreamingDetail: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .drawBehind {
                drawRoundRect(color = white, cornerRadius = CornerRadius(12.dp.toPx()))
            }
            .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.clickable {
                onNavigateMoreLiveStreaming()
            }
        ) {
            Text(
                text = "最近直播",
                style = TextStyle(color = black333, fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1.0f)
            )
            Text(text = "更多", style = TextStyle(color = grey999, fontSize = 14.sp))
            Icon(
                Icons.Rounded.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
        liveStreamingList.forEach {
            RecentlyLiveStreaming(it, onNavigateLiveStreamingDetail)
        }
    }

}




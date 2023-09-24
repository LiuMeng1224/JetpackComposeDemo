package com.example.jetpack_compose_demo1.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpack_compose_demo1.ui.theme.green00cc7e
import com.example.jetpack_compose_demo1.ui.theme.greyE6
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay


/**
 * 自动轮播图
 * @param images 图片集合
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(images: List<String>, modifier: Modifier = Modifier) {
    val pageCount = images.size
    val startIndex = 0
    val pagerState = rememberPagerState(initialPage = startIndex)

    // 页码转换
    fun pageMapper(index: Int) = index % images.size

    Box(modifier = modifier) {
        HorizontalPager(
            count = pageCount, state = pagerState,
            modifier = Modifier.matchParentSize()
        ) { index ->
            // 计算页面下标
            val page = pageMapper(index)
            BannerItem(imgUrl = images[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = green00cc7e,
            inactiveColor = greyE6,
            indicatorWidth = 10.dp,
            indicatorHeight = 4.dp,
            spacing = 5.dp,
            pageCount = pageCount,
            pageIndexMapping = ::pageMapper,
            modifier = Modifier
                .align(
                    Alignment.BottomCenter
                )
                .padding(bottom = 8.dp)
        )

        var underDragging by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(key1 = Unit) {
            pagerState.interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is PressInteraction.Press -> underDragging = true
                    is PressInteraction.Release -> underDragging = false
                    is PressInteraction.Cancel -> underDragging = false
                    is DragInteraction.Start -> underDragging = true
                    is DragInteraction.Stop -> underDragging = false
                    is DragInteraction.Cancel -> underDragging = false
                }
            }
        }

        if (underDragging.not()) {
            LaunchedEffect(key1 = underDragging) {
                try {
                    while (true) {
                        delay(1000L)
                        val current = pagerState.currentPage
                        val nextPage = current + 1
                        val toPage = pageMapper(nextPage)
                        if (underDragging.not()) {
                            if (toPage > current) {
                                pagerState.animateScrollToPage(toPage)
                            } else {
                                pagerState.scrollToPage(toPage)
                            }
                        }
                    }
                } catch (e: CancellationException) {
                    Log.e("HorizontalPagerIndicator", "CancellationException == ${e.toString()}")
                }
            }
        }

    }
}

@Composable
fun BannerItem(imgUrl: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = imgUrl, contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .height(115.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable {
                    // 点击事件
                }
        )
    }
}


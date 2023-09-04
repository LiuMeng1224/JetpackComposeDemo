package com.example.jetpack_compose_demo1.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import com.example.jetpack_compose_demo1.ui.CategoryItem
import com.example.jetpack_compose_demo1.ui.theme.black333
import com.example.jetpack_compose_demo1.ui.theme.green00cc7e
import com.example.jetpack_compose_demo1.ui.theme.grey999
import com.example.jetpack_compose_demo1.ui.theme.greyE6
import com.example.jetpack_compose_demo1.ui.theme.greyEE
import com.example.jetpack_compose_demo1.ui.theme.white


@Composable
fun Recommend(categoryList: MutableList<MutableList<CategoryItem>>) {
    val bannerImages = mutableListOf<String>()
    bannerImages.add("https://mooc-image.nosdn.127.net/f9b76cada0c54532a4cebe9e452cd631.png?imageView&quality=100&thumbnail=1552y720")
    bannerImages.add("https://mooc-image.nosdn.127.net/ef30f3089541433e886c7a4e8a2f2e78.png?imageView&quality=100")
    bannerImages.add("https://mooc-image.nosdn.127.net/bc7c883eff4c4a37895e364b3daf52a6.jpg?imageView&quality=100&thumbnail=1552y720")
    bannerImages.add("https://edu-image.nosdn.127.net/a9500e957bca4b3385eaadf2999470d8.png?imageView&quality=100")
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
        RecentlyLiveStreamingList()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseCategoryGrid(categoryList: MutableList<MutableList<CategoryItem>>) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val pagerState = rememberPagerState(pageCount = {
            categoryList.size
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
                    items(categoryList[page]) { category ->
                        CategoryItem(category)
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
fun CategoryItem(category : CategoryItem) {
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
fun LatestCourses(bannerImages: MutableList<String>) {
    Row(
        modifier = Modifier
        .height(115.dp)
    ) {
        Banner(images = bannerImages, modifier = Modifier
            .weight(2.0f)
            .height(115.dp))
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
fun RecentlyLiveStreamingList() {
    val liveStreamingList = mutableListOf<LiveStreaming>()
    liveStreamingList.add(LiveStreaming("25考研计算机全年高分复习规划", "https://mooc-image.nosdn.127.net/2ff9ea0335f043548e84510f6d30dda6.png?imageView&quality=100&thumbnail=312y312", "未开始", "08月15日 19:00-21:00", "研芝士计算机考研"))
    liveStreamingList.add(LiveStreaming("T121DAY1：专升本招录政策解读暨全流程备考规划", "https://mooc-image.nosdn.127.net/11c3629c7a3544d7b6a87d245a4c49d4.png?imageView&quality=100&thumbnail=96y96", "未开始", "08月15日 19:30-21:30", "哎上课专升本"))
    liveStreamingList.add(LiveStreaming("上海热门院校难度分析及横向对比(下)", "https://mooc-image.nosdn.127.net/ab8977a7cb414592ad447e71fe3f3f6f.jpg?imageView&quality=100&thumbnail=800y800", "未开始", "08月15日 19:30-21:00", "水木观畴"))

    Column(
        modifier = Modifier
            .drawBehind {
                drawRoundRect(color = white, cornerRadius = CornerRadius(12.dp.toPx()))
            }
            .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "最近直播",
                style = TextStyle(color = black333, fontSize = 18.sp, fontWeight = FontWeight.Bold ),
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
            RecentlyLiveStreaming(it)
        }
    }

}




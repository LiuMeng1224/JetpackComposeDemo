package com.example.jetpack_compose_demo1.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetpack_compose_demo1.model.LiveStreaming
import com.example.jetpack_compose_demo1.ui.theme.black333
import com.example.jetpack_compose_demo1.ui.theme.grey999
import com.example.jetpack_compose_demo1.ui.theme.greyAfc0cc
import com.example.jetpack_compose_demo1.ui.theme.white

@Composable
fun RecentlyLiveStreaming(item: LiveStreaming, onNavigateLiveStreamingDetail: (String) -> Unit) {
    Column(
        modifier = Modifier.clickable {
            onNavigateLiveStreamingDetail(item.name)
        }
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = item.image,
                contentDescription = "LiveStreamingImage",
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
                    .clip(RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Row {
                    Text(
                        text = item.status,
                        style = TextStyle(fontSize = 10.sp, color = white),
                        modifier = Modifier
                            .drawBehind {
                                drawRoundRect(greyAfc0cc, cornerRadius = CornerRadius(4.dp.toPx()))
                            }
                            .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = item.date,  style = TextStyle(fontSize = 12.sp, color = grey999))
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = item.name,  style = TextStyle(fontSize = 16.sp, color = black333))
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "讲师：" + item.lecturer,  style = TextStyle(fontSize = 12.sp, color = grey999))
            }
        }
    }
}


package com.example.jetpack_compose_demo1.ui.live

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.jetpack_compose_demo1.model.DemoData
import com.example.jetpack_compose_demo1.ui.components.RecentlyLiveStreaming

@Composable
fun LiveStreamingList(onClickLeftArrow: () -> Unit, onNavigateLiveStreamingDetail: (String) -> Unit) {
    val liveStreamings = remember { DemoData.getLiveStreamingList() }
    Column {
        Row (modifier = Modifier.padding(15.dp)){
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        onClickLeftArrow()
                    }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text =  "直播列表")
        }
        Spacer(modifier = Modifier.height(20.dp))
        liveStreamings.forEach {
            RecentlyLiveStreaming(it, onNavigateLiveStreamingDetail)
        }
    }
}
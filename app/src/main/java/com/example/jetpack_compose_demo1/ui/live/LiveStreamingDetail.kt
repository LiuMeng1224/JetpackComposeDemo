package com.example.jetpack_compose_demo1.ui.live

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_demo1.ui.navigation.MainDestination

@Composable
fun LiveStreamingDetail(id : String, onNavigateMain: (String) -> Unit, onClickLeftArrow: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
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
            Text(text = "直播详情 --$id", modifier = Modifier.weight(1.0f))
            Icon(
                Icons.Rounded.Home,
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        onNavigateMain(MainDestination.MAIN_ROUTE)
                    }
            )
        }
    }
}
package com.example.jetpack_compose_demo1.model

import androidx.compose.runtime.Immutable
import java.io.Serializable

@Immutable
data class MainTabBarItem(val title:String, val path:String) : Serializable


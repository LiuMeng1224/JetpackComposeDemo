package com.example.jetpack_compose_demo1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_demo1.ui.CategoryItem
import com.example.jetpack_compose_demo1.ui.compose.NationalBoutique
import com.example.jetpack_compose_demo1.ui.compose.Recommend
import com.example.jetpack_compose_demo1.ui.theme.Jetpack_compose_demo1Theme
import com.example.jetpack_compose_demo1.ui.theme.black333
import com.example.jetpack_compose_demo1.ui.theme.green00cc7e
import com.example.jetpack_compose_demo1.ui.theme.grey444

class MainActivity : ComponentActivity() {

    private val navigationTitles: MutableList<String> = mutableListOf()
    private val categoryList: MutableList<MutableList<CategoryItem>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationTitles()
        initCategoryList()
        setContent {
            Jetpack_compose_demo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        HeaderSearchView()
                        HomeNavigationBar(navigationTitles)
                        HomePage(categoryList)
                    }
                }
            }
        }
    }

    private fun initNavigationTitles() {
        navigationTitles.add("精选")
        navigationTitles.add("国家精选")
        navigationTitles.add("期末突击")
        navigationTitles.add("大学应试英语")
        navigationTitles.add("理工学农学")
        navigationTitles.add("四六级")
        navigationTitles.add("外语")
        navigationTitles.add("经济管理")
        navigationTitles.add("考研")
        navigationTitles.add("考研冲刺")
        navigationTitles.add("职场提升")
        navigationTitles.add("计算机")
        navigationTitles.add("有声课堂")
        navigationTitles.add("求职就业")
        navigationTitles.add("音乐与艺术")
        navigationTitles.add("心理学")
        navigationTitles.add("文史哲学")
        navigationTitles.add("医学与保健")
        navigationTitles.add("专升本")
        navigationTitles.add("教育教学")
        navigationTitles.add("保研")
        navigationTitles.add("大学生竞赛")
        navigationTitles.add("期末高分学长笔记")
    }

    private fun initCategoryList() {
        val tempList1 = mutableListOf<CategoryItem>()
        tempList1.add(CategoryItem("国家精选", "https://edu-image.nosdn.127.net/557e0e76ec864eea890d69371aa5c80c.png?imageView&quality=100"))
        tempList1.add(CategoryItem("计算机", "https://edu-image.nosdn.127.net/b487ddb5a026454984e9b0ce1d12ee77.png?imageView&quality=100"))
        tempList1.add(CategoryItem("经济管理", "https://edu-image.nosdn.127.net/829d20cf845348cf9edcfdeda86b8f73.png?imageView&quality=100"))
        tempList1.add(CategoryItem("心理学", "https://edu-image.nosdn.127.net/516079a3af4d4e6a92ad06bb488f620f.png?imageView&quality=100"))
        tempList1.add(CategoryItem("职场提升", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"))
        tempList1.add(CategoryItem("考研", "https://mooc-image.nosdn.127.net/745878b86b514443941975461701d495.png?imageView&quality=100"))
        tempList1.add(CategoryItem("四六级", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"))
        tempList1.add(CategoryItem("期末突击", "https://mooc-image.nosdn.127.net/f85d341d894449678dc63d6ea948cbf3.png?imageView&quality=100&thumbnail=144y144"))
        tempList1.add(CategoryItem("专升本", "https://edu-image.nosdn.127.net/7bdbb33501824d83a5cf62ca48c20260.png?imageView&quality=100"))
        tempList1.add(CategoryItem("更多", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"))
        val tempList2 = mutableListOf<CategoryItem>()
        tempList2.add(CategoryItem("求职就业", "https://mooc-image.nosdn.127.net/706f3afe68bb4ab9aef6be74463f230b.png?imageView&quality=100"))
        tempList2.add(CategoryItem("应试英语", "https://mooc-image.nosdn.127.net/ac39c29b391c428684e5a2a190af573b.png?imageView&quality=100&thumbnail=144y144"))
        tempList2.add(CategoryItem("有声课堂", "https://mooc-image.nosdn.127.net/f4a408442d704a05ab5d274915b180c0.png?imageView&quality=100"))
        tempList2.add(CategoryItem("兴趣技能", "https://mooc-image.nosdn.127.net/0a5a9096d87647d98050d50e03a86a3c.png?imageView&quality=100"))
        tempList2.add(CategoryItem("保研", "https://mooc-image.nosdn.127.net/4180121d7ae44ba79e139a2d46b5450b.png?imageView&quality=100&thumbnail=144y144"))
        categoryList.add(tempList1)
        categoryList.add(tempList2)
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
            style = TextStyle(color = green00cc7e, fontSize = 13.sp ),
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
            style = TextStyle(color = black333, fontSize = 14.sp ),
            modifier = Modifier
                .padding(end = 2.dp)
                .clickable {
                    Log.e("clickable", "----登录")
                })
        Text(text = "|", style = TextStyle(color = black333, fontSize = 16.sp ))
        Text(
            text = "注册",
            style = TextStyle(color = black333, fontSize = 14.sp ),
            modifier = Modifier
                .padding(end = 2.dp)
                .clickable {
                    Log.e("clickable", "----注册")
                })
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun HomeNavigationBar(navigationTitles: List<String>) {
    var selectedTitle by rememberSaveable { mutableStateOf("精选") }
    Row {
        LazyRow(modifier = Modifier
            .height(39.dp)
            .weight(1.0f)
        ) {
            items(navigationTitles, key = { it } ) { title ->
                NavigationItem(title, selectedTitle, onClickItem = {
                    selectedTitle = it

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
            style = TextStyle(fontSize = 16.sp, color = if(navigationTitle == selectedTitle)  green00cc7e  else grey444),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    onClickItem(navigationTitle)
                }
        )
        Spacer(modifier = Modifier.height(5.dp))
        if(navigationTitle == selectedTitle) {
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

@Composable
fun HomePage(categoryList: MutableList<MutableList<CategoryItem>>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "recommend") {
        composable("recommend") { Recommend(categoryList = categoryList) }
        composable("nationalBoutique") { NationalBoutique(/*...*/) }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_compose_demo1Theme {
        HeaderSearchView()
    }
}
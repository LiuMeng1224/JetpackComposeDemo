package com.example.jetpack_compose_demo1.model

object DemoData {
    fun getMainTabBarList():List<MainTabBarItem> = mainTabBarList

    fun getCategoryList():List<CategoryItem> = categoryList

    fun getLiveStreamingList():List<LiveStreaming> = liveStreamingList
    
    fun getBannerImageList():List<String> = bannerImageList

}

private val mainTabBarList = listOf(
    MainTabBarItem("精选", "MainPage_index0"),
    MainTabBarItem("国家精选", "MainPage_index1"),
    MainTabBarItem("期末突击", "MainPage_index2"),
    MainTabBarItem("大学应试英语", "MainPage_index3"),
    MainTabBarItem("理工学农学", "MainPage_index4"),
    MainTabBarItem("四六级", "MainPage_index5"),
    MainTabBarItem("外语", "MainPage_index6"),
    MainTabBarItem("经济管理", "MainPage_index7"),
    MainTabBarItem("考研", "MainPage_index8"),
    MainTabBarItem("考研冲刺", "MainPage_index9"),
    MainTabBarItem("职场提升", "MainPage_index10"),
    MainTabBarItem("计算机", "MainPage_index11"),
    MainTabBarItem("有声课堂", "MainPage_index12"),
    MainTabBarItem("求职就业", "MainPage_index13"),
    MainTabBarItem("音乐与艺术", "MainPage_index14"),
    MainTabBarItem("心理学", "MainPage_index15"),
    MainTabBarItem("文史哲学", "MainPage_index16"),
    MainTabBarItem("医学与保健", "MainPage_index17"),
    MainTabBarItem("专升本", "MainPage_index18"),
    MainTabBarItem("教育教学", "MainPage_index19"),
    MainTabBarItem("保研", "MainPage_index20"),
    MainTabBarItem("大学生竞赛", "MainPage_index21"),
    MainTabBarItem("期末高分学长笔记", "MainPage_index22")
)

private val categoryList = listOf(
    CategoryItem("国家精选", "https://edu-image.nosdn.127.net/557e0e76ec864eea890d69371aa5c80c.png?imageView&quality=100"),
    CategoryItem("计算机", "https://edu-image.nosdn.127.net/b487ddb5a026454984e9b0ce1d12ee77.png?imageView&quality=100"),
    CategoryItem("经济管理", "https://edu-image.nosdn.127.net/829d20cf845348cf9edcfdeda86b8f73.png?imageView&quality=100"),
    CategoryItem("心理学", "https://edu-image.nosdn.127.net/516079a3af4d4e6a92ad06bb488f620f.png?imageView&quality=100"),
    CategoryItem("职场提升", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"),
    CategoryItem("考研", "https://mooc-image.nosdn.127.net/745878b86b514443941975461701d495.png?imageView&quality=100"),
    CategoryItem("四六级", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"),
    CategoryItem("期末突击", "https://mooc-image.nosdn.127.net/f85d341d894449678dc63d6ea948cbf3.png?imageView&quality=100&thumbnail=144y144"),
    CategoryItem("专升本", "https://edu-image.nosdn.127.net/7bdbb33501824d83a5cf62ca48c20260.png?imageView&quality=100"),
    CategoryItem("更多", "https://mooc-image.nosdn.127.net/bccd02fb0d8f40ee9855189cd3269ead.png?imageView&quality=100&thumbnail=144y144"),
    CategoryItem("求职就业", "https://mooc-image.nosdn.127.net/706f3afe68bb4ab9aef6be74463f230b.png?imageView&quality=100"),
    CategoryItem("应试英语", "https://mooc-image.nosdn.127.net/ac39c29b391c428684e5a2a190af573b.png?imageView&quality=100&thumbnail=144y144"),
    CategoryItem("有声课堂", "https://mooc-image.nosdn.127.net/f4a408442d704a05ab5d274915b180c0.png?imageView&quality=100"),
    CategoryItem("兴趣技能", "https://mooc-image.nosdn.127.net/0a5a9096d87647d98050d50e03a86a3c.png?imageView&quality=100"),
    CategoryItem("保研", "https://mooc-image.nosdn.127.net/4180121d7ae44ba79e139a2d46b5450b.png?imageView&quality=100&thumbnail=144y144")
)

private val liveStreamingList = listOf(
    LiveStreaming("25考研计算机全年高分复习规划", "https://mooc-image.nosdn.127.net/2ff9ea0335f043548e84510f6d30dda6.png?imageView&quality=100&thumbnail=312y312", "未开始", "08月15日 19:00-21:00", "研芝士计算机考研"),
    LiveStreaming("T121DAY1：专升本招录政策解读暨全流程备考规划", "https://mooc-image.nosdn.127.net/11c3629c7a3544d7b6a87d245a4c49d4.png?imageView&quality=100&thumbnail=96y96", "未开始", "08月15日 19:30-21:30", "哎上课专升本"),
    LiveStreaming("上海热门院校难度分析及横向对比(下)", "https://mooc-image.nosdn.127.net/ab8977a7cb414592ad447e71fe3f3f6f.jpg?imageView&quality=100&thumbnail=800y800", "未开始", "08月15日 19:30-21:00", "水木观畴")
)

private val bannerImageList = listOf(
    "https://mooc-image.nosdn.127.net/f9b76cada0c54532a4cebe9e452cd631.png?imageView&quality=100&thumbnail=1552y720",
    "https://mooc-image.nosdn.127.net/ef30f3089541433e886c7a4e8a2f2e78.png?imageView&quality=100",
    "https://mooc-image.nosdn.127.net/bc7c883eff4c4a37895e364b3daf52a6.jpg?imageView&quality=100&thumbnail=1552y720",
    "https://edu-image.nosdn.127.net/a9500e957bca4b3385eaadf2999470d8.png?imageView&quality=100"
)



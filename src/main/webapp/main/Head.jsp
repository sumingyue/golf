<%@ page contentType="text/html; charset=utf-8"%>
<div class="clear"></div>
	<!-- <div class="grid_4">
			<div class="logo">
				<img src="./img/logo.jpg" class="img-full" alt="" height="70"
					border="0">
			</div>
		</div> -->	
<div class="grid_24" style="text-align:right">
<form class="searchform" method="get" action="queryNews.do">
          <input name="keyword" type="text" class="nav10" id="srchtxt" value="">
          <input type="submit"  value="站内搜索">
        </form>
</div>
<ul class="nav grid_24 ">
	<li class="nav-list-item" style="width: 30px;"><a
		href="index.do    " class="nav-list-tit" id="nav_index">首页</a></li>
	<li class="nav-list-item"><a href="c.do?id=1" class="nav-list-tit"
		id="nav_news">综合</a>
		<ul class="nav-sub-menu clear-fix">
			<li class="nav-sub-item"><a href="sc.do?id=1">国际</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=2">国内</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=3">产业</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=4">品牌</a></li>
		</ul></li>
	<li class="nav-list-item"><a href="c.do?id=2" class="nav-list-tit"
		id="nav_match">赛事</a>
		<ul class="nav-sub-menu clear-fix">
			<li class="nav-sub-item"><a href="sc.do?id=7">国际</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=8">国内</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=9">品牌</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=12">球员</a></li>
		</ul></li>
	<li class="nav-list-item"><a href="c.do?id=4" class="nav-list-tit"
		id="nav_travel">旅游</a>
		<ul class="nav-sub-menu clear-fix">
			<li class="nav-sub-item"><a href="sc.do?id=19">附近</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=20">省市</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=21">线路</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=22">游记</a></li>
		</ul></li>
	<li class="nav-list-item"><a href="c.do?id=5" class="nav-list-tit"
		id="nav_school">学院</a>
		<ul class="nav-sub-menu clear-fix">
			<li class="nav-sub-item"><a href="sc.do?id=25">礼仪</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=26">规则</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=27">技术</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=28">挥杆</a></li>
		</ul></li>
	<li class="nav-list-item"><a href="c.do?id=6" class="nav-list-tit"
		id="nav_zixun">资讯</a>
		<ul class="nav-sub-menu clear-fix" style="width:80px;_width:75px;+width:75px;">
			<li class="nav-sub-item"><a href="sc.do?id=38">球会</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=39">会籍</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=32">活动</a></li>
			<li class="nav-sub-item"><a href="sc.do?id=41">练习场</a></li>
		</ul></li>
	<li class="nav-list-item"><a href="learn.do?id=42" class="nav-list-tit"
		id="nav_qiuchang">学球</a></li>
	<li class="nav-list-item"><a href="club.do" class="nav-list-tit"
		id="nav_qiuchang">球场</a></li>
	<li class="nav-list-item"><a href="teams.do" class="nav-list-tit"
		id="nav_team">球队</a></li>
	<li class="nav-list-item"><a href="pics.do" class="nav-list-tit"
		id="nav_pic">图片</a></li>
	<li class="nav-list-item"><a href="specials.do" class="nav-list-tit"
		id="nav_zhuanti">专题</a></li>
	<li class="nav-list-item"><a href="products.do"
		class="nav-list-tit" id="nav_shop">商城</a>
	</li>
	<!-- <li class="nav-list-item"><a href="" class="nav-list-tit"
		id="nav_util">实用</a>
		<ul class="nav-sub-menu clear-fix">
			<li class="nav-sub-item"><a href="">预定</a></li>
			<li class="nav-sub-item"><a href="">行程</a></li>
			<li class="nav-sub-item"><a href="">会员</a></li>
			<li class="nav-sub-item"><a href="">优惠</a></li>
		</ul></li> -->
	<li class="nav-list-item"><a href="" class="nav-list-tit"
		id="nav_interact">互动</a>
		<ul class="nav-sub-menu clear-fix" style="width:120px;">
			<li class="nav-sub-item"><a href="orderCourt.do">预定球场</a></li>
			<li class="nav-sub-item"><a href="addNews.do">发布新闻</a></li>
			<li class="nav-sub-item"><a href="messages.do">用户留言</a></li>
			<li class="nav-sub-item"><a href="matchService.do">赛事服务</a></li>
		</ul></li>
</ul>

<%@ page contentType="text/html; charset=utf-8"%>
<div class="topSearch">
	<form class="form-search" action="queryNews.do">
		<input type="text" name="keyword" placeholder="高尔夫" value='${keyword}' class="input-small search-query">
		<button type="submit" class="btn input-small">Search</button>
	</form>
</div>
<div class="navbar navbar-inverse">
	<div class="navbar-inner navbar-title">
		<button type="button" class="btn btn-navbar" data-toggle="collapse"
			data-target=".nav-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="brand" href="index.do">苏州高尔夫</a>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<li id="news" class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">新闻 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="c.do?categoryId=4">本地资讯</a></li>
						<li><a href="c.do?categoryId=1">综合新闻</a></li>
						<li><a href="c.do?categoryId=2">赛事新闻</a></li>
						<li><a href="c.do?categoryId=3">高球学院</a></li>
					</ul></li>
				<li id="travel"><a href="travels.do">旅游</a></li>
				<li id="court"><a href="club.do">球场</a></li>
				<li id="team"><a href="teams.do">球队</a></li>
				<li id="drivingRange"><a href="drivingRanges.do">练习场</a></li>
				<li id="learnClub"><a href="learnClubs.do">学球</a></li>
				<li id="special"><a href="specials.do">专题</a></li>
				<!-- <li id="special"><a href="specials.do">图片</a></li> -->
				<li id="service" class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">服务<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="addNews.do">新闻发布</a></li>
						<li><a href="orderCourt.do">球场预定</a></li>
						<li><a href="messages.do">用户留言</a></li>
						<li><a href="matchService.do">赛事服务</a></li>
					</ul></li>
				<li id="contact"><a href="contact.do">关于我们</a></li>
			</ul>
		</div>
	</div>
</div>

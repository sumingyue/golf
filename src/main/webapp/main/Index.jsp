<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网</title>
<meta name="Keywords" content="苏州高尔夫,专业高尔夫平台，精彩高尔夫赛事，高尔夫球场预定，高尔夫旅游">
<meta name="Description" content=" ">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="wrap container_24">
		<!-- 头部，logo及banner -->
		<!-- 单行大广告 -->
		<jsp:include page="./Head.jsp"></jsp:include>
		<!--  导航 -->
		<div class="grid_24">
			<a href="${adwordsService.adwords[0].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[0].image.path}"
				height="70" border="0"></a>
		</div>
		<div class="clear"></div>
		<!-- 一行 -->
		<div class="grid_7 slide-list-container" id="slide">
			<ul class="slide-list">
			<s:iterator value="newsZongHe.imageNews" status="vs">
				<s:if test="#vs.index==0">
					<li class="active slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${maxTitle}</a></li>
				</s:if>
				<s:else>
					<li class="slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${maxTitle}</a></li>
				</s:else>
			</s:iterator>
			</ul>
			<ul class="slide-nums">
			<s:iterator value="newsZongHe.imageNews" status="vs">
				<s:if test="#vs.index==0">
					<li class="active"><a href="#">${vs.index+1}</a></li>
				</s:if>
				<s:else>
					<li><a href="#">${vs.index+1}</a></li>
				</s:else>
			</s:iterator>
			</ul>
		</div>

		<div class="grid_10">
			<div class="mod-box-horizon mod-box-horizon-last news-block"
				id="jiaodianxinwen">
				<div class="mod-hd"><span class="more"><a href="c.do?id=1" target="_blank">更多</a></span><a href="c.do?id=1" target="_blank">综合新闻</a></div>
				<div class="mod-bd" style="height:240px;">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="newsZongHe.firstNews.id"/>"
								target="_blank"><s:property value="newsZongHe.firstNews.title" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="newsZongHe.secondNews" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="title" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="newsZongHe.thirdNews" status="vs">
							<li class="article-item large"><a
								href="news.do?id=<s:property value="id"/>" target="_blank">[<s:property
										value="smallCategory.name" />]&nbsp;&nbsp;<s:property value="title" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active"><a href="sc.do?id=${newsZongHe.smallCategory1.id}" target="_blank">${newsZongHe.smallCategory1.name}</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=${newsZongHe.smallCategory2.id}" target="_blank">${newsZongHe.smallCategory2.name}</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=${newsZongHe.smallCategory3.id}" target="_blank">${newsZongHe.smallCategory3.name}</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews1" status="vs">
							<li class="article-item small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews2" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="newsZongHe.smallCategoryNews3" status="vs">
							<li class="article-item  small"><a
								href="news.do?id=${id}" target="_blank">${title}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 两条广告 -->
		<div class="grid_12">
		<a href="${adwordsService.adwords[5].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[5].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_12">
		<a href="${adwordsService.adwords[6].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[6].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="clear"></div>

	</div>
	
</body>
</html>

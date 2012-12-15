<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网</title>
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
			<s:iterator value="imageNews" status="vs">
				<s:if test="#vs.index==0">
					<li class="active slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${smallTitle}</a></li>
				</s:if>
				<s:else>
					<li class="slide-list-item"><img class="slide-list-img"
					src="${image.path}"
					alt=""> <a class="slide-list-tit" href="news.do?id=${id}">${smallTitle}</a></li>
				</s:else>
			</s:iterator>
			</ul>
			<ul class="slide-nums">
			<s:iterator value="imageNews" status="vs">
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
				<div class="mod-hd">焦点新闻</div>
				<div class="mod-bd" style="height: 268px;">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="firstJiaoDian.id"/>"
								target="_blank"><s:property value="firstJiaoDian.maxTitle" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="firstJiaoDians" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="smallTitle" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="secondJiaoDians" status="vs">
							<li class="article-item"><a
								href="news.do?id=<s:property value="id"/>" target="_blank">[<s:property
										value="smallCategory.name" />]&nbsp;&nbsp;<s:property value="maxTitle" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-vertical mod-box-vertical-last" id="tupianji">
				<div class="mod-hd">
					<h3 style="padding-top:20px;"><a href="pics.do" target="_blank">图片专题</a></h3>
				</div>
				<div class="mod-bd">
					<ul class="gallery">
						<s:iterator value="imageSpecials" status="vs">
							<li class="image-item"><img
							src="${image.path}"
							alt="专题图片"> <a href="pic.do?id=${id}">${shortName}</a></li>
							</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-horizon-last" id="zhuantiqu">
				<div class="mod-hd"><span class="more"><a href="specials.do" target="_blank">更多</a></span><a href="specials.do" target="_blank">专题区</a></div>
				<div class="mod-bd" style="height:143px; overflow: hidden;">
					<ul class="mod-article-list">
						<s:iterator value="specialNews" status="vs">
							<li class="article-item"><a
								href="special.do?id=<s:property value="id"/>" target="_blank"><s:property value="title" /></a></li>
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

		<!--  练习场 -->
		<div class="grid_7">
			<div class="mod-box-horizon tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active"><a href="sc.do?id=32" target="_blank">活动资讯</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=33" target="_blank">优惠信息</a></h3>
					<h3 class="tab-hd-item last"><a href ="sc.do?id=34" target="_blank">人才供求</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="huoDongZiXuns" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="youHuiXinXis" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item mod-article-list">
						<s:iterator value="renCaiQiuGongs" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>

			<%-- <div class="mod-box-horizon mod-box-horizon-last tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active"><a href="sc.do?id=36" target="_blank">本地时尚</a></h3>
					<h3 class="tab-hd-item"><a href="sc.do?id=37" target="_blank">社会热点</a></h3>
					<h3 class="tab-hd-item last"><a href="sc.do?id=35" target="_blank">综合新闻</a></h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="mod-article-list active tab-pannel-item">
						<s:iterator value="benDiShiShangs" status="vs">
								<li class="article-item"><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a><span class="time">${dateStr}</span></li>
						</s:iterator>
					</ul>
					<ul class="mod-article-list tab-pannel-item">
						<s:iterator value="sheHuiReDians" status="vs">
							<li class="article-item"><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a><span class="time">${dateStr}</span></li>
						</s:iterator>
					</ul>
					<ul class="mod-article-list tab-pannel-item">
						<s:iterator value="zongHeZiXuns" status="vs">
							<li class="article-item"><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a><span class="time">${dateStr}</span></li>
						</s:iterator>
					</ul>
				</div>
			</div> --%>

		</div>
		<div class="grid_10">
			<div class="mod-box-horizon  news-block">
				<div class="mod-hd"><span class="more"><a href="c.do?id=2" target="_blank">更多</a></span><a href="c.do?id=2" target="_blank">赛事新闻</a></div>
				<div class="mod-bd">
					<div class="headline">
						<h3 class="mod-hd">
							<a href="news.do?id=<s:property value="firstSaiShi.id"/>"
								target="_blank"><s:property value="firstSaiShi.maxTitle" /></a>
						</h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix">
								<s:iterator value="firstSaiShis" status="vs">
									<li class="news-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="smallTitle" /></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="secondSaiShis" status="vs">
							<li class="article-item"><a
								href="news.do?id=<s:property value="id"/>" target="_blank">[<s:property
										value="smallCategory.name" />]&nbsp;&nbsp;<s:property
										value="maxTitle" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<%-- <div class="mod-box-horizon mod-box-horizon" id="lianxichang">
				<div class="mod-hd"><span class="more"><a href="club.do" target="_blank">更多</a></span><a href="club.do" target="_blank">球场</a></div>
				<div class="mod-bd">
					<a href="court.do?id=${courtImage.courtId}"><img
						src="${courtImage.image.path}"
						class="img-full img-ads" alt="图片"></a>
					 
					<ul class="mod-article-list">
						<s:iterator value="courts" status="vs">
							<li class="article-item"><a
								href="court.do?id=<s:property value="id"/>" target="_blank"><s:property
										value="name" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div> --%><div class="mod-box-horizon mod-box-horizon-last" id="lianxichang">
				<div class="mod-hd"><span class="more"><a href="sc.do?id=43" target="_blank">更多</a></span><a href="sc.do?id=41" target="_blank">练习场新闻</a></div>
				<div class="mod-bd">
					<ul class="mod-article-list">
							<a href="news.do?id=${lianXiChang.id}"><img
						src="${lianXiChang.image.path}"
						class="img-full img-ads" alt="图片"></a>
							<ul class="mod-article-list">
								<s:iterator value="lianXiChangs" status="vs">
									<li class="article-item"><a
										href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="smallTitle" /></a></li>
								</s:iterator>
							</ul>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>

		<!-- 六块广告 -->
		<div class="grid_4">
			<a href="${adwordsService.adwords[7].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[7].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_4">
			<a href="${adwordsService.adwords[8].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[8].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_4">
			<a href="${adwordsService.adwords[9].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[9].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_4">
			<a href="${adwordsService.adwords[10].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[10].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_4">
			<a href="${adwordsService.adwords[11].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[11].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="grid_4">
			<a href="${adwordsService.adwords[12].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[12].image.path}"
				height="90" border="0"></a>
		</div>
		<div class="clear"></div>

		<!-- 球队之家 高球旅游 贵宾通道 -->
		<div class="grid_7">
		
			<div class="mod-box-horizon mod-box-horizon-last" id="qiudui">
				<div class="mod-hd"><span class="more"><a href="teams.do" target="_blank">更多</a></span><a href="teams.do" target="_blank">球队</a></div>
				<div class="mod-bd">
					<ul class="mod-article-list">
							<%-- <a href="news.do?id=${lianXiChang.id}"><img
						src="${lianXiChang.image.path}"
						class="img-full img-ads" alt="图片"></a> --%>
							<ul class="mod-article-list">
								<s:iterator value="teamNews" status="vs">
									<li class="article-item"><a
										href="teamNews.do?id=<s:property value="id"/>" target="_blank"><s:property
												value="shortTitle" /></a></li>
								</s:iterator>
							</ul>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon mod-box-horizon-last" id="gaoqiulvyou">
				<div class="mod-hd">
					<span class="more"><a href="c.do?id=4" target="_blank">更多</a></span><a href="c.do?id=4" target="_blank">高球旅游</a>
				</div>
				<div class="mod-bd">
					<ul class="gallery clear-fix">
						<s:iterator value="lvYouImages" status="vs">
							<li class="image-item"><img
								src="<s:property value="image.path"/>" /> <a
								href="news.do?id=<s:property value="id"/>" target="_blank"><s:property
										value="smallTitle" /></a></li>
						</s:iterator>
					</ul>
					<ul class="mod-article-list">
						<s:iterator value="lvYous" status="vs">
							<li class="article-item"><a
								href="news.do?id=<s:property value="id"/>" target="_blank">[<s:property
										value="smallCategory.name" />]&nbsp;&nbsp;<s:property
										value="maxTitle" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon mod-box-horizon-last" id="guibintongdao">
				<div class="mod-hd">
					贵宾通道
				</div>
				<div class="mod-bd">
					<ul>
						<li><a href="${adwordsService.adwords[13].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[13].image.path}" height="90"
								border="0"></a></li>
						<li><a href="${adwordsService.adwords[14].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[14].image.path}" height="90"
								border="0"></a></li>
						<li><a href="${adwordsService.adwords[15].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[15].image.path}" height="90"
								border="0"></a></li>
						<li><a href="${adwordsService.adwords[16].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[16].image.path}" height="90"
								border="0"></a></li>
						<li><a href="${adwordsService.adwords[17].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[17].image.path}" height="90"
								border="0"></a></li>
					</ul>
				</div>
			</div>
		</div>

		<!-- 通栏广告 -->
		<div class="grid_24">
			<a href="${adwordsService.adwords[19].url}"
							target="_blank"><img class="img-full"
								src="${adwordsService.adwords[19].image.path}" height="90"
								border="0"></a>
		</div>
		<div class="clear"></div>

		<!-- 人物，动态，故事，学堂 -->
		<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=16" target="_blank">更多</a></span><a href="sc.do?id=16" target="_blank">人物访谈</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="renWus" status="vs">
							<li class="article-item">
							<span class="time">${dateStr}</span>
							<a href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=15" target="_blank">更多</a></span><a href="sc.do?id=15" target="_blank">观点评论</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="guanDianPingLuns" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>

		<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=13" target="_blank">更多</a></span><a href="sc.do?id=13" target="_blank">高球动态</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="gaoQiuDongTais" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-vertical-last">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=17" target="_blank">更多</a></span><a href="sc.do?id=17" target="_blank">协会新闻</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="xieHuiXinWens" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=40" target="_blank">更多</a></span><a href="sc.do?id=40" target="_blank">供求信息</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="gongQiuXinXis" status="vs">
							<li class="article-item"><span class="time">${dateStr}</span><a
								href="news.do?id=${id}" target="_blank">${smallTitle}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-horizon-last tab-list"
				id="paiming">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active">世界排名</h3>
					<h3 class="tab-hd-item last">奖金排名</h3>
				</div>
				<div class="mod-bd tab-pannel">
					<div class="tab-pannel-item active">
						<div class="table-wrap">
							<table class="table">
								<tr>
									<td width="15%">排名</td>
									<td width="45%">球员</td>
									<td width="40%">积分</td></tr>
								<s:iterator value="jiFenPlayers" status="status">
									<tr class="${status.index%2==0?'odd':'even'}">
										<td>${status.index+1}</td>
										<td>${name}</td>
										<td>${score}</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
					<div class="tab-pannel-item">
						<div class="table-wrap">
							<table class="table">
									<tr>
									<td width="15%">排名</td>
									<td width="45%">球员</td>
									<td width="40%">奖金</td></tr>
								<s:iterator value="jiangJinPlayers" status="status">
									<tr class="${status.index%2==0?'odd':'even'}">
										<td>${status.index+1}</td>
										<td>${name}</td>
										<td>$${bonusStr}</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="grid_24">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					合作媒体
				</div>
				<div class="mod-bd">
					<ul class="link-list">
				<s:iterator value="heZuoMedias" status="status">
						<li><a href="${url}">${name}</a></li>
					</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<br>
		<div class="grid_24">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					友情链接
				</div>
				<div class="mod-bd">
					<ul class="link-list">
					<s:iterator value="youQingMedias" status="status">
						<li><a href="${url}">${name}</a></li>
					</s:iterator>
					</ul>
				</div>
			</div>
		</div>

		<jsp:include page="./Foot.jsp"></jsp:include>
		
		
	<div class="left-banner side-banner">
		<div class="banner-img">
			<a href="#" class="close">x</a>
			<a href="${adwordsService.adwords[1].url}" target="_blank"><img 
			src="${adwordsService.adwords[1].image.path}"
				height="150" border="0"  width="150" />
			</a>
		</div>
		<div class="banner-img">
			<a href="#" class="close">x</a>
			<a href="${adwordsService.adwords[2].url}" target="_blank"><img 
			src="${adwordsService.adwords[2].image.path}"
			height="150" border="0"  width="150" /></a>
		</div>
	</div>
	
	<div class="right-banner side-banner">
		<div class="banner-img">
			<a href="#" class="close">x</a>
			<a href="${adwordsService.adwords[3].url}" target="_blank"><img 
			src="${adwordsService.adwords[3].image.path}"
			height="150" border="0"  width="150" />
			</a>
		</div>
		<div class="banner-img">
			<a href="#" class="close">x</a>
			<a href="${adwordsService.adwords[4].url}" target="_blank"><img 
			src="${adwordsService.adwords[4].image.path}"
			height="150" border="0"  width="150" />
			</a>
		</div>
	</div>
	
	</div>
	
</body>
</html>

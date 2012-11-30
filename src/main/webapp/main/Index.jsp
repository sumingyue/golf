<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
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
		<jsp:include page="./Head.jsp"></jsp:include>
		<!--  导航 -->
		<!-- 单行大广告 -->
		<div class="clear"></div>
		<!-- 三格广告 -->
		<div class="grid_7">
			<img class="img-full" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" height="90" border="0">
		</div>
		<div class="grid_10">
			<img class="img-full" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" height="90" border="0">
		</div>
		<div class="grid_7">
			<img class="img-full" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" height="90" border="0">
		</div>
		<div class="clear"></div>

		<!-- 一行 -->
		<div class="grid_7 slide-list-container" id="slide">
			<ul class="slide-list">
				<li class="active slide-list-item">
					<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
					<a class="slide-list-tit" href="">title 1</a>
				</li>
				<li class="slide-list-item">
					<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
					<a class="slide-list-tit" href="">title 2</a>
				</li>
				<li class="slide-list-item">
					<img class="slide-list-img" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="">
					<a class="slide-list-tit" href="">title 3</a>
				</li>
			</ul>
		</div>

		<div class="grid_10" >
			<div class="mod-box-horizon mod-box-horizon-last news-block" id="jiaodianxinwen">
				<div class="mod-hd">焦点新闻</div>
				<div class="mod-bd" style="height: 268px;">
					<div class="headline">
						<h3 class="mod-hd"><a href="nd.do?id=<s:property value="firstHot.id"/>" target="_blank"><s:property value="firstHot.title"/></a></h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								<s:iterator value="firstHots" status="vs">
									<li class="news-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					
					<ul class="mod-article-list">
						<s:iterator value="secondHots" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank">[<s:property value="smallCategory.name"/>]<s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon">
			<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-full img-ads" alt="广告图">
			</div>
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd">专题区</div>
				<div class="mod-bd" style="height:168px;overflow:hidden;">
					<ul class="mod-article-list">
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>

		
		<!-- 两条广告 -->
		<div class="grid_12">
			<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-full img-ads" alt="广告图">
		</div>
		<div class="grid_12">
			<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-full img-ads" alt="广告图">
		</div>
		<div class="clear"></div>

		<!--  练习场 -->
		<div class="grid_7">
			<div class="mod-box-horizon tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active">活动资讯</h3>
					<h3 class="tab-hd-item">优惠信息</h3>
					<h3 class="tab-hd-item last">人才供求</h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="active tab-pannel-item mod-article-list">
						<s:iterator value="huoDongZiXun" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item">
						<s:iterator value="youHuiXinXi" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
					<ul class="tab-pannel-item">
						<s:iterator value="renCaiQiuGong" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			<div class="mod-box-horizon mod-box-horizon-last tab-list lxctab">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active">活动资讯</h3>
					<h3 class="tab-hd-item">优惠信息</h3>
					<h3 class="tab-hd-item last">人才供求</h3>
				</div>
				<div class="mod-bd tab-pannel">
					<ul class="mod-article-list active tab-pannel-item">
						<s:iterator value="benDiShiShang" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
						<li class="article-item"><a href="#">标题</a><span class="time">2010-2-12</span></li>
					</ul>
					<ul class="mod-article-list tab-pannel-item">
						<s:iterator value="sheHuiReDian" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
					<ul class="mod-article-list tab-pannel-item">
					<s:iterator value="zongHeZiXun" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
		</div>	
		<div class="grid_10">
			<div class="mod-box-horizon  news-block">
				<div class="mod-hd">赛事新闻</div>
				<div class="mod-bd">
					<div class="headline">
						<h3 class="mod-hd"><a href="nd.do?id=<s:property value="firstMatch.id"/>" target="_blank"><s:property value="firstMatch.title"/></a></h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix">
								<s:iterator value="firstMatchs" status="vs">
									<li class="news-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
								</s:iterator>
							</ul>
						</div>
					</div>
					<ul class="mod-article-list">
						<s:iterator value="secondMatchs" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			<div class="mod-box-vertical mod-box-vertical-last" id="tupianji">
				<div class="mod-hd"><h3>图片集</h3></div>
				<div class="mod-bd">
					<ul class="gallery">
						<li class="image-item">
							<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
						<li class="image-item">
							<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
						
						<li class="image-item">
							<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
						
						<li class="image-item">
							<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
					</ul>
				</div>
			</div>
		</div>	
		<div class="grid_7">
			<div class="mod-box-horizon mod-box-horizon-last" id="lianxichang">
				<div class="mod-hd">练习场</div>
				<div class="mod-bd">
					
					<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-full img-ads" alt="图片">
					<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-full img-ads" alt="图片">
					<ul class="mod-article-list">
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
					</ul>
				</div>
			</div>

		</div>	
		<div class="clear"></div>

		<!-- 六块广告 -->
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="grid_4">
			<img alt="广告" src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" class="img-ads">
		</div>
		<div class="clear"></div>

		<!-- 球队之家 高球旅游 贵宾通道 -->
		<div class="grid_7">
			<%-- <div class="mod-box-horizon" id="qiuduizhijia">
				<div class="mod-hd"><span class="more">更多</span>球队之家</div>
				<div class="mod-bd">
					<ul class="gallery">
						<li class="image-item">
							<img src="" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
						<li class="image-item">
							<img src="" alt="球队图片">
							<a href="">苏美高尔夫球队</a>
						</li>
					</ul>
				</div>
			</div> --%>
			<div class="mod-box-horizon mod-box-horizon-last tab-list" id="paiming">
				<div class="mod-hd tab-hd">
					<h3 class="tab-hd-item active">世界排名</h3>
					<h3 class="tab-hd-item">奖金排名</h3>
				</div>
				<div class="mod-bd tab-pannel">
					<div class="tab-pannel-item active">
					<div class="table-wrap">
					<table class="table">
					<tr>
						<td>1</td>
						<td>2</td>
					</tr>
					<tr>
						<td>3</td>
						<td>3</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr></table></div>
					</div>
					<div class="tab-pannel-item">
					<div class="table-wrap">
					<table class="table">
					<tr>
						<td>1</td>
						<td>2</td>
					</tr>
					<tr>
						<td>3</td>
						<td>3</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr>
					<tr>
						<td>4</td>
						<td>5</td>
					</tr></table>
					</div>
					</div>
				</div>
					
			</div>

			<div class="mod-box-vertical mod-box-vertical-last" id="qiuduihuodong">
				<div class="mod-hd"><h3>球队活动</h3></div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
						<li class="article-item">标题</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon mod-box-horizon-last" id="gaoqiulvyou">
				<div class="mod-hd"><span class="more">更多</span>高球旅游</div>
				<div class="mod-bd">
					<ul class="gallery">
						<s:iterator value="lvYouImages" status="vs">
							<li class="image-item">
								<img src="<s:property value="image.path"/>" />
								<a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
							</li>
							<li class="image-item">
								<img src="<s:property value="image.path"/>" />
								<a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
							</li>
						</s:iterator>
					</ul>
					<ul class="mod-article-list">
							<s:iterator value="lvYous" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon mod-box-horizon-last" id="guibintongdao">
				<div class="mod-hd"><span class="more">更多</span>贵宾通道</div>
				<div class="mod-bd">
					<ul>
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
							
						<li>
							<img src="" alt="贵宾通道" class="img-full">
						</li>	
					</ul>
				</div>
			</div>
		</div>

		<!-- 通栏广告 -->
		<div class="grid_24">
			<img src="http://www.512golf.cn/admin/uploadfile/201092714481132168.jpg" alt="广告位" class="img-ads">
		</div>
		<div class="clear"></div>

		<!-- 人物，动态，故事，学堂 -->
		<div class="grid_7">
			<div class="mod-box-horizon" id="renwu">
				<div class="mod-hd"><span class="more">更多</span>人物</div>
				<div class="mod-bd">
					<ul class="gallery">
						<s:iterator value="renWuImages" status="vs">
							<li class="image-item">
								<img src="<s:property value="image.path"/>" onclick="" style="width:60px;height:60px"/>
								<a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-vertical mod-box-vertical-last" id="renwufangwen">
				<div class="mod-hd"><h3>人物访问</h3></div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="renWus" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
					</ul>
				</div>
			</div>
		</div>

		<div class="grid_10">
			<div class="mod-box-horizon">
				<div class="mod-hd"><span class="more">更多</span>高球动态</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="dongTai" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-vertical-last">
				<div class="mod-hd"><span class="more">更多</span>协会新闻</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="xieHuis" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_7">
			<div class="mod-box-horizon">
				<div class="mod-hd"><span class="more">更多</span>球界故事</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="qiuJie" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd"><span class="more">更多</span>观点评论</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="qiuJie" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>

		<div class="clear"></div>


		<!-- 商务，用品，丽人，球场，品牌 -->
		<!-- <div class="grid_4">
			<img src="" alt="商务" class="img-ads">
		</div>
		<div class="grid_4">
			<img src="" alt="用品" class="img-ads">
		</div>
		<div class="grid_4">
			<img src="" alt="丽人" class="img-ads">
		</div>
		<div class="grid_4">
			<img src="" alt="球场" class="img-ads">
		</div>
		<div class="grid_4">
			<img src="" alt="品牌" class="img-ads">
		</div>
		<div class="grid_4">
			<img src="" alt="广告" class="img-ads">
		</div> -->
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body></html>

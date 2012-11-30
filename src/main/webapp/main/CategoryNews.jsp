<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/news.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<style>
	.news-slide{float:left;width:585px;background-image:url(http://i0.sinaimg.cn/ty/2011hqj/golf/images/sports_golf_zxh_0214_02.png);}
	.news-article{float:left;width:200px;}
	.gallery{}
	.gallery .bigpics{float:left;}
	.gallery .bigpic{display: none;position: relative;}
	.gallery .bigpic{float:left;}
	.gallery .bigpic img{width:500px;height:300px;}
	.gallery .bigpic h3{position: absolute;bottom:0;background-color: rgba(0,0,0,0.5);width:100%;color:#fff;padding:10px 0;text-align: center;}
	.gallery .bigpics .active{display: block;}
	.gallery .smallpics{float:left;}
	.gallery .smallpic{padding:6px 10px;}
	.gallery .smallpics .active{background-image:url(http://i0.sinaimg.cn/ty/2011hqj/golf/images/sports_golf_zxh_0214_02.png);}

	.news-article .article-item{border-bottom:1px dashed #ccc;padding:10px 0;width:350px;text-align: center}
	.headline{width:365px;height:100px;}
	.headline .mod-bd .news-item a{padding:8px 10px}
	</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_24">
			<div id="slidearticles">
				<div class="news-slide">
					<div id="slide-container" class="gallery clear-fix">
						<ul class="bigpics clear-fix">
							<li class="bigpic">
								<h3>Title</h3>
								<p><img src="http://i1.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29157DT20121127100815.jpg" alt=""></p>
							</li>
							<li class="bigpic">
								<h3>Title</h3>
								<p><img src="http://i1.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29149DT20121127160052.jpg" alt=""></p>
							</li>
							<li class="bigpic">
								<h3>Title</h3>
								<p><img src="http://i3.sinaimg.cn/ty/golf/idx/2012/1127/U1340P6T967D1F29161DT20121127071748.jpg" alt=""></p>
							</li>
							<li class="bigpic active">
								<h3>Title</h3>
								<p><img src="http://i0.sinaimg.cn/ty/http/video.sina.com.cn/p/sports/golf/v/2012-11-04/U6083P6T408D122651F8868DT20121104174904.jpg" alt=""></p>
							</li>
						</ul>
						<ul class="smallpics">
							<li class="smallpic"><img src="http://i3.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29165DT20121127160052.jpg" alt=""></li>
							<li class="smallpic"><img src="http://i0.sinaimg.cn/ty/golf/idx/2012/1126/U2010P6T967D1F29166DT20121126164618.jpg" alt=""></li>
							<li class="smallpic"><img src="http://i2.sinaimg.cn/ty/golf/idx/2012/1127/U364P6T967D1F29167DT20121127100815.jpg" alt=""></li>
							<li class="smallpic active"><img src="http://i2.sinaimg.cn/ty/golf/idx/2012/1127/U1340P6T967D1F29168DT20121127071748.jpg" alt=""></li>
						</ul>
					</div>
				</div>
				<ul class="news-article">
					<li class="headline">
						<h3 class="mod-hd"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战赛18人阵容</a></h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战赛阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战阵容</a></li>
								
							</ul>
						</div>
					</li>
					<li class="headline">
						<h3 class="mod-hd"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战赛18人阵容</a></h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布战赛18人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世18人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世8人阵容</a></li>
								
							</ul>
						</div>
					</li>
					
					<li class="headline">
						<h3 class="mod-hd"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑战赛18人阵容</a></h3>
						<div class="mod-bd">
							<ul class="news-list clear-fix active tab-pannel-item">
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布战赛18人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世18人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世界挑人阵容</a></li>
								
									<li class="news-item"><a href="newDetail?id=27" target="_blank">伍兹公布世8人阵容</a></li>
								
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!-- div class="grid_24">
			<ul class="mod-article-list">
				<s:iterator value="hotNews" status="vs">
					<li class="article-item"><a href="#"><s:property
								value="title" /></a><span class="time">2010-2-12</span></li>
				</s:iterator>
			</ul>
		</div-->
			<!-- div class="grid_24">
			<ul class="mod-article-list">
				<s:iterator value="imageNews" status="vs">
					<li class="article-item"><a href="#"><s:property
								value="title" /></a><span class="time">2010-2-12</span></li>
				</s:iterator>
			</ul>
		</div-->
		<s:iterator value="categoryNews" status="vs">
		<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd"><span class="more"><a href="sc.do?id=<s:property value="smallCategory.id"/>">更多</a></span> <s:property value="smallCategory.name"/> </div>
				<div class="mod-bd"><ul class="mod-article-list">
						<s:iterator value="news" status="vs">
							<li class="article-item"><a href="nd.do?id=<s:property value="id"/>"><s:property value="title"/></a><span class="time"><s:property value="dateStr"/></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		</s:iterator>
		
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">

	var tabPannel = new TabPannel({
		container:$("#slide-container"),
		triggerType:"hover",
		headCS:".smallpic",
		itemCS:".bigpic",
		activeCls:"active"
	});

	</script>
</body></html>

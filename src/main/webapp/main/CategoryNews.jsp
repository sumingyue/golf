<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#news').addClass('active');
	});
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li><a href="c.do?categoryId=${category.id}">${category.name}</a>
					<span class="divider">/</span></li>
				<li class="active">最新新闻</li>
			</ul>
		</div>
		<div class="row">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list" style="height: 440px;">
						<li class="nav-header">${category.name}</li>
						<li class="active"><a href="#">最新新闻</a></li>
						<li class="nav-header">分类新闻</li>
						<s:iterator value="smallCategories" status="vs">
							<li><a href="sc.do?id=<s:property value="id"/>">${name}</a></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="span10">
				<div class="row">
					<div class="span5">
						<div id="myCarousel" class="carousel slide">
							<ol class="carousel-indicators">
								<s:iterator value="imageNews" status="vs">
									<s:if test="#vs.index==0">
										<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
									</s:if>
									<s:else>
										<li data-target="#myCarousel" data-slide-to="${vs.index}"></li>
									</s:else>
								</s:iterator>
							</ol>
							<!-- Carousel items -->
							<div class="carousel-inner">
								<s:iterator value="imageNews" status="vs">
									<s:if test="#vs.index==0">
										<div class="active item">
											<img class="category-news-img" src="<s:property value="image.path"/>" />
											<div class="carousel-caption">
												<p>
													<a href="news.do?id=${id}">${title}</a>
												</p>
											</div>
										</div>
									</s:if>
									<s:else>
										<div class="item">
											<img class="category-news-img" src="<s:property value="image.path"/>" />
											<div class="carousel-caption">
												<p class="text-center">
													<a href="news.do?id=${id}">${title}</a>
												</p>
											</div>
										</div>
									</s:else>
								</s:iterator>
							</div>
							<!-- Carousel nav -->
							<a class="carousel-control left" href="#myCarousel"
								data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
								href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>
					</div>
					<div class="span5">
						<table class="table table-striped table-bordered table-hover">
							<tr><th>最新新闻</th></tr>
							<s:iterator value='hotNews'>
								<tr><td ><a href="news.do?id=${id}">${title}</a></td></tr>			
							</s:iterator>
						</table>
					</div>
				</div>
			</div>
			</div>
			<jsp:include page="./Foot.jsp"></jsp:include>
			</div><
</body>
</html>

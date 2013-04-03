<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#court').addClass('active');
	});
</script>
<style>
	.court-img{
		height:350px;
		width:540px;
	}
	.map-img{
		height:250px;
		width:377px;
	}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="position">
			<ul class="breadcrumb border">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li><a href="club.do">球场</a><span class="divider">/</span></li>
				<li class="active">${court.name}</li>
			</ul>
		</div>
		<div class="club-detail">
			<div class="span7 myhidden border" style="height:350px;">
				<div id="myCarousel" class="carousel slide">
					<ol class="carousel-indicators">
					    <s:iterator value="courtImages" status="vs">
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
						<s:iterator value="courtImages" status="vs">
							<s:if test="#vs.index==0">
								<div class="active item">
									<img class="court-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p class='text-center'>${imageDes}</p>
									</div>
								</div>
							</s:if>
							<s:else>
								<div class="item">
									<img class="court-img" src="<s:property value="image.path"/>"  />
									<div class="carousel-caption">
										<p class='text-center'>${imageDes}</p>
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
			<div class="span5 myhidden border" style="height:350px;">
				<div>
					<h4 class="breadcrumb title ">基本资料 &nbsp;&nbsp;<a href="#" target="blank">球道详细信息</a></h4>
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<td>地址</td>
							<td>${court.address}</td>
						</tr>
						<tr>
							<td>电话</td>
							<td>${court.phone}</td>
						</tr>
					</table>
					<h4 class="breadcrumb title ">获得评价</h4>
					<div class="left">${court.awards}</div>
				</div>
			</div>
			<div class="span7 myhidden border top" style="height:400px;">
				<div>
					<h4 class="breadcrumb title ">球场介绍</h4>
					<div class="left">${court.customIntro}</div>
				</div>
			</div>
			<div class="span5 myhidden border top" style="height:400px;">
				<div>
					<h4 class="breadcrumb title ">球场地图</h4>
					<div><img class="map-img" src="<s:property value="court.mapImage.path"/>" />
					</div>
					<div class="left top">
						<s:property value="court.mapIntroduction" />
					</div>
				</div>
			</div>
		</div>
		</br>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	
</body>
</html>

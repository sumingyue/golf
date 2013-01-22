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
		<!--  导航 -->
		<jsp:include page="./Head.jsp"></jsp:include>
		<!-- 单行大广告 -->
		<div class="grid_24">
			<a href="${adwordsService.adwords[0].url}" target="_blank"><img
				class="img-full" src="${adwordsService.adwords[0].image.path}"
				height="70" border="0"></a>
		</div>
		<jsp:include page="./index/ZongHe.jsp"></jsp:include>
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
		<jsp:include page="./index/SaiShi.jsp"></jsp:include>
		<jsp:include page="./index/LvYou.jsp"></jsp:include>
		<jsp:include page="./index/ZiXun.jsp"></jsp:include>
		<div class="clear"></div>
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

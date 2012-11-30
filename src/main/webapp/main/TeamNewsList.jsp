<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
	<meta charset="UTF-8">
		<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/news.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_17">
			<ul class="mod-article-list">
				<s:iterator value="teamNewss" status="vs">
					<li class="article-item"><a href="#"><s:property
						value="title" /></a><span class="time"></li>
				</s:iterator>
			</ul>
		</div>
		<div class="grid_7">
			
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body></html>

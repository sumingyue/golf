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
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li><a href="travels.do">旅游</a> <span class="divider">/</span></li>
				<li><a href="travel.do?id=${travelLog.travel.id}">${travelLog.travel.name}</a> <span class="divider">/</span></li>
				<li class="active">${travelLog.title}</li>
		</ul>
	</div>
		<table class=" table-bordered" width="100%"><tr><td>
			<h3 class="text-center">
				<s:property value="travelLog.title" />
			</h3>
			<div class="arc-content">
				<s:property value="travelLog.content" escape="false" />
			</div></td></tr></table>
		</br>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>





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
		$('#learnClub').addClass('active');
	});
</script>
<style>
	.learnClub-img{
		height:350px;
		width:540px;
	}
	.title{
		color:#6899f7;
		background-color:#d9edf7;
		background:#d9edf7;
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
				<li><a href="learnClubs.do">学球机构</a><span class="divider">/</span></li>
				<li class="active">${learnClub.name}</li>
			</ul>
		</div>
		<div class="club-detail">
			<div class="span7 myhidden border" style="height: 350px;">
				<img src="${learnClub.image.path}" class="learnClub-img">
			</div>
			<div class="span5 myhidden border" style="height: 350px;">
				<div>
					<h4 class="breadcrumb title ">
						基本资料 &nbsp;&nbsp;<a href="#" target="blank">学球详细信息</a>
					</h4>
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<td>名称</td>
							<td>${learnClub.name}</td>
						</tr>
						<tr>
							<td>地址</td>
							<td>${learnClub.address}</td>
						</tr>
						<tr>
							<td>电话</td>
							<td>${learnClub.phone}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="span12 border top" style="width:938px;height:400px;margin-left:0px;">
				<div>
					<h4 class="breadcrumb title ">学球机构介绍</h4>
					<div class="left">${learnClub.introduction}</div>
				</div>
			</div>
		</br>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

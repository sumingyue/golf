<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US"><head>
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
		$('#team').addClass('active');
	});
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="position">
			<ul class="breadcrumb border">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li><a href="teams.do">苏州球队</a><span class="divider">/</span></li>
				<li class="active">${team.name}</li>
			</ul>
		</div>
		<div class="row">
  			<div class="span2">
  				<div class="well sidebar-nav">
					<ul class="nav nav-list" style="height:600px;">
						<li class="nav-header" >${team.name}</li>
						<li id="newsList" class="active"><a href="#">球队介绍</a></li>
						<li class="nav-header" >跟踪报道</li>
						<li id="newsList"><a href="teamNewss.do?teamId=${team.id}&type=1">球队新闻</a></li>
						<li id="newsList"><a href="teamNewss.do?teamId=${team.id}&type=2">活动报道</a></li>
						<li id="newsList"><a href="teamNewss.do?teamId=${team.id}&type=3">月历成绩</a></li>
						<li id="newsList"><a href="teamNewss.do?teamId=${team.id}&type=4">精彩图文</a></li>
						<li id="newsList"><a href="teamNewss.do?teamId=${team.id}&type=5">球队章程</a></li>
					</ul></div>
  			</div>
			<div class="span10">
				<img id="main-img" src="<s:property value="team.logo.path"/>" />
				<div class="row top">
					<div class="span5 myhidden top" style="height: 300px">
						<table class="table table-striped table-bordered table-hover">
							<tbody>
								<tr>
							<th width="30%">建队时间</th>
							<td><s:property value="team.setUpTime"/></td>
						</tr>
						<tr>
							<th>首任会长</th>
							<td><s:property value="team.founder"/></td>
						</tr>
						<tr>
							<th>现任会长</th>
							<td><s:property value="team.captain"/></td>
						</tr>
						<tr>
							<th>成员组成</th>
							<td><s:property value="team.members"/></td>
						</tr>
						<tr>
							<th>球队口号</th>
							<td><s:property value="team.slogan"/></td>
						</tr>
						<tr>
							<th>球队战绩</th>
							<td><s:property value="team.achievement"/></td>
						</tr>
							</tbody>
						</table>
					</div>
					<div class="span5 myhidden top" style="height: 300px">
						<div>
							<h4 class="breadcrumb title ">球队公告</h4>
							<div class="left">${team.introduction}</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

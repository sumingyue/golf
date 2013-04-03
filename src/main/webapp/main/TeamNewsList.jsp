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
			var type = ${type};
			$('#teamnews'+type).addClass('active');
			$('#team').addClass('active');
	});
	</script>
	<style>
		#main-img{
			width:780px;
			height:350px;
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
				<li><a href="teams.do">球队</a><span class="divider">/</span></li>
				<li><a href="team.do?id=${team.id}">${team.name}</a><span class="divider">/</span></li>
				<li class="active"><s:if test="type==1">球队新闻</s:if>
					<s:elseif test="type==2">活动报道</s:elseif>
					<s:elseif test="type==3">月历成绩</s:elseif>
					<s:elseif test="type==4">精彩图文</s:elseif>
					<s:elseif test="type==5">球队章程</s:elseif></li>
			</ul>
		</div>
		<div class="row">
  			<div class="span2">
  				<div class="well sidebar-nav">
					<ul class="nav nav-list" style="height:600px;">
						<li class="nav-header" >${team.name}</li>
						<li id="teamnews"><a href="team.do?teamId=${team.id}">球队介绍</a></li>
						<li class="nav-header" >跟踪报道</li>
						<li id="teamnews1"><a href="teamNewss.do?teamId=${team.id}&type=1">球队新闻</a></li>
						<li id="teamnews2"><a href="teamNewss.do?teamId=${team.id}&type=2">活动报道</a></li>
						<li id="teamnews3"><a href="teamNewss.do?teamId=${team.id}&type=3">月历成绩</a></li>
						<li id="teamnews4"><a href="teamNewss.do?teamId=${team.id}&type=4">精彩图文</a></li>
						<li id="teamnews5"><a href="teamNewss.do?teamId=${team.id}&type=5">球队章程</a></li>
					</ul></div>
  			</div>
			<div class="span10">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr><th width="80%"><s:if test="type==1">球队新闻</s:if>
					<s:elseif test="type==2">活动报道</s:elseif>
					<s:elseif test="type==3">月历成绩</s:elseif>
					<s:elseif test="type==4">精彩图文</s:elseif>
					<s:elseif test="type==5">球队章程</s:elseif></th><th>时间</th></tr>
					</thead>
					<s:iterator value="teamNewss" status="vs">
					<tr><td><a href="teamNews.do?id=${id}"><s:property
									value="title" /></a></td>
									<td><s:date name="creationDate" format="yyyy-MM-dd" /></td></tr>
					</s:iterator>
				</table>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

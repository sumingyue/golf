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
		$('#travel').addClass('active');
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
				<li class="active">旅游</li>
			</ul>
	</div>
	<div class="row-fluid">
			<div class="span9">
				<table class="table table-striped table-bordered table-hover">
					<thead>
					<tr>
						<th width="30%" class="center" >旅游名称</th>
						<th width="25%" class="center">类型</th>
						<th width="10%" class="center">价格</th>
						<th width="35%" class="center">包含</th>
					</tr>
					</thead>
						<tbody>
							<s:iterator value="travels" status="vs">
								<tr>
								<td><a href="travel.do?id=${id}">${name}</a></td>
								<td><s:if test="type==1">休闲旅游</s:if>
									<s:elseif test="2">品质旅游</s:elseif>
									<s:elseif test="3">挑战旅游</s:elseif>
								</td>
								<td>${price}</td>
								<td>${introduction}</td></tr>
							</s:iterator></tbody></table>
			</div>
			<div class="span3">
				<table class="table table-striped table-bordered table-hover">
					<thead><tr class="center"><td>最新游记</td></tr>
					<tbody>
							<s:iterator value="travelLogs" status="vs">
								<tr><td><a href="travelLog.do?id=${id}">${title}</a></td></tr>
							</s:iterator>
							</tbody></table>
			</div>
	</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>

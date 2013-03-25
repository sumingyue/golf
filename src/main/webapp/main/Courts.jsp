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
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li class="active">苏州球场</li>
			</ul>
		</div>
		<div class="row-fluid">
			<div class="span12" >
				<table class="table table-striped table-bordered table-hover">
					<thead>
					<tr>
						<th>名称</th>
						<th>地址</th>
						<th>电话</th>
					</tr></thead><tbody>
					<s:iterator value="courts" status="vs">
						<tr>
						<td><a href="court.do?id=${id}"><s:property value="name" /></a></td>
						<td><s:property value="address" /></td>
						<td><s:property value="phone" /></td>
						</tr>
					</s:iterator></tbody>
				</table>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

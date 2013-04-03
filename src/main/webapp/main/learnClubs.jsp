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
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li class="active">学球机构</li>
			</ul>
		</div>
		<div class="row-fluid">
			<div class="span12" >
				<table class="table table-striped table-bordered table-hover">
					<thead>
					<tr>
						<th  class="center"  width="23%">学球机构</th>
						<th  class="center"  width="27%">基本信息</th>
						<th  class="center"  width="23%">学球机构</th>
						<th  class="center"  width="27%">基本信息</th>
					</tr></thead><tbody>
					<s:iterator value="learnClubs" status="vs">
						<s:if test="#vs.odd"><tr></s:if>
							<td><a href="learnClub.do?id=${id}">
									<img src="${image.path}" class="image-item">
								</a>
							</td>
							<td><h4><a href="learnClub.do?id=${id}"><s:property value="name" /></a></h4>
							<p>地址：<s:property value="address" /></p>
							<p>电话：<s:property value="phone" /></p></td>
						<s:if test="#vs.even || #vs.last"></tr></s:if>
					</s:iterator></tbody>
				</table>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

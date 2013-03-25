<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 |
	苏州专业高尔夫门户网站</title>
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
<style>
.image-item {
	width: 220px;
	height: 115px;
}
.center{
	text-align:center;
	align:center;
	background-color:#d9edf7;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li class="active">苏州球队</li>
			</ul>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<table class="table table-striped table-bordered table-hover">
					<thead>
					<tr>
						<th width="25%" class="center" >球队Logo</th>
						<th width="75%" class="center">球队介绍</th>
					</tr>
					</thead>
						<tbody>
							<s:iterator value="teams" status="vs">
								<tr>
									<td><a href="team.do?teamId=<s:property value="id"/>"><img
											class="image-item" src="<s:property value="logo.path"/>"
											alt="图片"></a></td>
									<td>
									<div class="myhidden" style="height:115px">
										<h5><a href="team.do?teamId=<s:property value="id"/>"><s:property
												value="name" /></a></h5>
										${introduction}
									</div>			
									</td>
								</tr>
							</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



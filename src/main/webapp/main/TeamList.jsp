<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	
<style>
	.image-item img{
		width:217px;
		height:200px;
	}
</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_24">
			<ul class="gallery">
				
				<s:iterator value="teams" status="vs">
					<li class="image-item">
					<img src="<s:property value="logo.path"/>" alt="图片">
					<a href="team.do?teamId=<s:property value="id"/>"><s:property value="name"/></a>
					</li>
				</s:iterator>
			</ul>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



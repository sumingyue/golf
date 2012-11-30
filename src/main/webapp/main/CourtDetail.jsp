<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/news.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_14">
			<s:iterator value="courtImages" status="vs">
				<img src="<s:property value="image.path"/>" />
			</s:iterator>
		</div>
		<div class="grid_10">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more">球场介绍 
				</div>
				<div class="mod-bd">
					<s:property value="court.introduction" escape="false" />
				</div>
			</div>
			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more">评价介绍 
				</div>
				<div class="mod-bd">
					<s:property value="court.awards" escape="false" />
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="grid_14">
			<s:property value="court.customIntro" escape="false" />
		</div>
		<div class="grid_10">
			<div class="mod-hd">
				<span class="more">行车路线 <img
					src="<s:property value="court.image.path"/>" />
			</div>
			<div class="mod-bd">
				<table>
				<s:iterator value="groups" status="vs">
					<tr>
						<td><s:property value="name"/></td>
						<td><s:iterator value="index" status="vs">
							<s:property/>
							</s:iterator>
						</td>
					</tr>
				</s:iterator>
				</table>
				<s:iterator value="all" status="vs">
					<img src="<s:property value="image.path"/>" />
					</s:iterator>
			</div>
		</div>
		
		<div class="grid_10">
			<div class="mod-hd">
				<span class="more">行车路线 <img
					src="<s:property value="court.image.path"/>" />
			</div>
			<div class="mod-bd">
				<s:property value="court.mapIntroduction" />
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
</body>
</html>

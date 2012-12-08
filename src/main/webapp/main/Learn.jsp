<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/newsDetail.css">
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<s:iterator value="news" status="vs">
			<div class="grid_8">
			<div class="mod-box-horizon">
				<div class="mod-hd"><a href="news.do?id=${id}"
					target="_blank">${smallTitle}</a></div>
				<div class="mod-bd">
				<s:property value="content" escape="false" />
				</div>
			</div>
			</div>
		</s:iterator>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



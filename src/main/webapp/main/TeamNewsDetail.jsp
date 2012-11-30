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
<style type="text/css">
.arc-head {
	text-align: center;
	margin: 0;
}

.arc-title {
	font-size: 18px;
}

.arc-info {
	padding: 5px 0;
}

.arc-content {
	margin: 0;
}

.arc-content p {
	margin-bottom: 15px;
	line-height: 22px;
}

.mod-bd {
	padding: 30px;
}

.mod-article-list {
	margin: 10px 0 30px 0;
}

.image-item {
	width: 140px;
}
</style>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_24">
		<div class="mod-box-horizon">
		<div class="mod-hd">首页 > <s:property value="teamNews.team.name"/> > <s:property value="teamNews.type"/></div>
		<div class="article">
						<div class="arc-head">
							<div class="arc-title">
								<s:property value="teamNews.title" />
							</div>
						</div>
						<div class="arc-content">
							<s:property value="teamNews.content" escape="false" />
						</div>
					</div>
					</div></div>

		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		new TabPannel({
			container : $("#slide"),
			triggerType : "hover",
			headCS : ".smallpic",
			itemCS : ".bigpic",
			activeCls : "active"
		});
	</script>
</body>
</html>



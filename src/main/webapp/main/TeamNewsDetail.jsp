<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
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
		<div class="mod-hd">首页 > <s:property value="teamNews.team.name"/> > <s:if test="teamNews.type==1">球队新闻</s:if>
					<s:elseif test="teamNews.type==2">活动报道</s:elseif>
					<s:elseif test="teamNews.type==3">月历成绩</s:elseif>
					<s:elseif test="teamNews.type==4">精彩图文</s:elseif>
					<s:elseif test="teamNews.type==5">规章制度</s:elseif>
					> 正文</div>
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



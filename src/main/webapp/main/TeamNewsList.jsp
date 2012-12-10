<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/news.css">
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_24">
			<div class="mod-box-horizon">
				<div class="mod-hd">
					您当前所在位置：球队 ->
					<s:property value="team.name" />
					->
					<s:if test="type==1">球队新闻</s:if>
					<s:elseif test="type==2">活动报道</s:elseif>
					<s:elseif test="type==3">月历成绩</s:elseif>
					<s:elseif test="type==4">精彩图文</s:elseif>
					<s:elseif test="type==5">规则制度</s:elseif>
				</div>
				<ul class="mod-article-list">
					<s:iterator value="teamNewss" status="vs">
						<li class="article-item"><a href="teamNews.do?id=${id}"><s:property
									value="title" /></a><span class="time"></li>
					</s:iterator>
				</ul>
			</div>
			
			<div class="paginate">
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
				<a href="?index=0">首页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&id=<s:property value="smallCategoryId"/>">上一页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&id=<s:property value="smallCategoryId"/>">下一页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.totalPage"/>&id=<s:property value="smallCategoryId"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
				<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
		</div>
		<div class="grid_7"></div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>

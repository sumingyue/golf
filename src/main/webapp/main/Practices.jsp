<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title></title>
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/news.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_8">

			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more">更多</span>球会资讯
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="qiuhui" status="vs">
							<li class="article-item"><a href="#"><s:property
										value="title" /></a><span class="time"><s:property
										value="dateStr" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>


			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more">更多</span>协会新闻
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="xiehui" status="vs">
							<li class="article-item"><a href="#"><s:property
										value="title" /></a><span class="time"><s:property
										value="dateStr" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>


			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd">
					<span class="more">更多</span>会籍关注
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="huiji" status="vs">
							<li class="article-item"><a href="#"><s:property
										value="title" /></a><span class="time"><s:property
										value="dateStr" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_16">
			<div class="mod-box-vertical mod-box-vertical-last" style="height:624px;">
				<div class="mod-hd">
					<h3>练习场</h3>
				</div>
				<div class="mod-bd">
					<div class="mod-inner">
						<table class="table">
							<tr>
								<th>名称</th>
							</tr>
								<s:iterator value="news" status="vs">
							<tr>
							<td><a href="#"><s:property
												value="title" /></a></td>
							</tr>
								</s:iterator>
						</table>
					</div><div>
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
				<a href="?pagedTool.pageIndex=0">首页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
				<a href="?pagedTool.pageIndex=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
				<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
				</div>
			</div>
			<div>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
</body>
</html>

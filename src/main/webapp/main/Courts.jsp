<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/news.css">
<style>
#table-container .mod-bd{
	position:relative;
}
#table-container td{
	padding:8px;
}

.title{
	font-weight:bold;
}
</style>
</head>
<body>
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_8">

			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=38">更多</a></span><a href="sc.do?id=38">球会资讯</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="qiuhui" status="vs">
							<li class="article-item"><span class="time"><s:property
										value="dateStr" /></span><a href="new.do?id=${id}"><s:property
										value="normalTitle" /></a></li>
						</s:iterator>
					</ul>
				</div>
			</div>


			<div class="mod-box-horizon">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=17">更多</a></span><a href="sc.do?id=17">协会新闻</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="xiehui" status="vs">
							<li class="article-item"><a href="new.do?id=${id}"><s:property
										value="normalTitle" /></a><span class="time"><s:property
										value="dateStr" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>


			<div class="mod-box-horizon mod-box-horizon-last">
				<div class="mod-hd">
					<span class="more"><a href="sc.do?id=39">更多</a></span><a href="sc.do?id=39">会籍资讯</a>
				</div>
				<div class="mod-bd">
					<ul class="mod-article-list">
						<s:iterator value="huiji" status="vs">
							<li class="article-item"><a href="new.do?id=${id}"><s:property
										value="normalTitle" /></a><span class="time"><s:property
										value="dateStr" /></span></li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="grid_16" id="table-container">
			<div class="mod-box-vertical mod-box-vertical-last" style="height:624px">
				<div class="mod-hd">
					<h3>球场</h3>
				</div>
				<div class="mod-bd">
					<div class="mod-inner" style="height:600px;">
						<table class="table" style="border:0px">
							<tr>
								<td width="35%" class="title">名称</td>
								<td width="35%" class="title">地址</td>
								<td width="30%" class="title">电话</td>
							</tr>
							<s:iterator value="courts" status="vs">
								<tr class="${vs.index%2==0?'odd':'even'}">
								<td><a href="court.do?id=${id}"><s:property value="name" /></a></td>
								<td><s:property value="address" /></td>
								<td><s:property value="phone" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
					<div class="paginate">
					共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
					<a href="?pageIndex=0">首页</a>&nbsp;&nbsp;
					<a href="?pageIndex=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
					<a href="?pageIndex=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
					<a href="?pageIndex=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
					共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
					<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
</body>
</html>

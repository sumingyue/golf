<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#special').addClass('active');
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
			<li class="active">专题</li>
		</ul>
	</div>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="75%" class="center">专题名称</th>
						<th width="25%" class="center">时间</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="specialNewss" status="vs">
						<tr>
							<td><a href="special.do?id=<s:property value="id"/>" target="blank"><s:property
										value="title" /></a></td>
							<td><s:date name="creationDate" format="yyyy-MM-dd" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="paginate table-bordered">
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
				<a href="?index=0">首页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
				<a href="?index=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
				共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
				<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>

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
		$('#news').addClass('active');
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
				<li><a href="c.do?categoryId=${smallCategory.category.id}">${smallCategory.category.name}</a>
					<span class="divider">/</span></li>
				<li class="active">${smallCategory.name}</li>
			</ul>
		</div>
		<div class="row">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list" style="height: 440px;">
						<li class="nav-header">${smallCategory.category.name}</li>
						<li><a href="c.do?categoryId=${smallCategory.category.id}">最新新闻</a></li>
						<li class="nav-header">分类新闻</li>
						<s:iterator value="smallCategories" status="vs">
							<s:if test="id==smallCategory.id"><li class="active"><a href="sc.do?id=<s:property value="id"/>">${name}</a></li></s:if>
							<s:else>	<li><a href="sc.do?id=<s:property value="id"/>">${name}</a></li>
							</s:else>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="span10">
				<table class="table table-striped table-bordered table-hover">
							<tr><th width="80%">最新新闻</th><th width="20%">时间</th></tr>
							<s:iterator value='news'>
								<tr><td><a href="news.do?id=${id}" target="_blank">${maxTitle}</a></td>
									<td>${dateStr}</td>
								</tr>			
							</s:iterator>
						</table>
						<div class="paginate table-bordered">
						共&nbsp;
						<s:property value="pagedTool.totalNumber" />
						&nbsp;条记录 <a href="?index=0&id=<s:property value="smallCategoryId"/>">首页</a>&nbsp;&nbsp; <a
							href="?index=<s:property value="pagedTool.pageIndex-1"/>&id=<s:property value="smallCategoryId"/>">上一页</a>&nbsp;&nbsp;
						<a
							href="?index=<s:property value="pagedTool.pageIndex+1"/>&id=<s:property value="smallCategoryId"/>">下一页</a>&nbsp;&nbsp;
						<a
							href="?index=<s:property value="pagedTool.totalPage"/>&id=<s:property value="smallCategoryId"/>">末页</a>&nbsp;&nbsp;
						共&nbsp;
						<s:property value="pagedTool.totalPage" />
						&nbsp;页,当前第&nbsp;
						<s:property value="pagedTool.pageIndex" />
						页&nbsp;
						<s:property value="pagedTool.pageSize" />
						条记录/页&nbsp;
					</div>
			</div>
			</div>
			<jsp:include page="./Foot.jsp"></jsp:include>
			</div>
</body>
</html>

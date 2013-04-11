<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="360-site-verification" content="606256f97c999416d747cb9dc422d619" />
<meta name="baidu-site-verification" content="OYcFb2jSwyjNyEuL" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
		<div>
			<ul class="breadcrumb">
				<li>当前位置：</li>
				<li><a href="index.do">首页</a> <span class="divider">/</span></li>
				<li class="active">图片</li>
			</ul>
		</div>
		<div class="row">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<s:iterator value="categorys" status="vs">
							<s:set name="categoryId" value="id" />  
							<li class="nav-header">${name}</li>
							<s:iterator value="smallCategories" status="status">
								<s:if test="smallCategoryId==id">
								<li class="active"><a href="?categoryId=${categoryId}&&smallCategory=<s:property value="id"/>">${name}</a></li>
								</s:if>
								<s:else>
								<li><a href="?categoryId=${categoryId}&&smallCategoryId=<s:property value="id"/>">${name}</a></li>
								</s:else>
							</s:iterator>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="span9">
					<s:iterator value="imageSpecials" status="vs">
					<s:if test="${vs.index mod(2)==0}"><div class="row-fluid"></s:if>
					<div class='span6'>
					<a class='text-warning' href="pic.do?id=<s:property value="id"/>"><img class="img-rounded special-img" src="<s:property value="image.path"/>" title="${name}" alt="${name}">
					</a><p class='text-center'><a class='text-success' href="pic.do?id=<s:property value="id"/>"><s:property value="name"/></a></p>
					</div>
					<s:if test="${vs.index mod(2)==1 || vs.last}"></div></s:if>
				</s:iterator>
			</div>
		</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>

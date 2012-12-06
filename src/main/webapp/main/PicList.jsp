<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/gallery.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<style>
	.image-item img{
		width:217px;
		height:200px;
	}
</style>
<script type="text/javascript">
function categoryChanged(){
	var categoryId = $('#imageSpecial_categoryId').val();
	window.location="?categoryId="+categoryId;
}

function smallCategoryChanged(){
	var categoryId = $('#imageSpecial_categoryId').val();
	var smallCategoryId = $('#imageSpecial_smallCategoryId').val();
	window.location="?categoryId="+categoryId+"&smallCategoryId="+smallCategoryId;
}
</script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="grid_24" align="center">
				一级分类：<s:select name="imageSpecial.categoryId"
							onchange="categoryChanged()"
							list="categorys" listKey="id" listValue="name" 
							headerKey="0" headerValue="ALL"
							value="categoryId" theme="simple" >
				</s:select>
				二级分类：<s:select name="imageSpecial.smallCategoryId"
					onchange="smallCategoryChanged()"
					list="smallCategorys" listKey="id" listValue="name"
					headerKey="0" headerValue="ALL"
					value="smallCategoryId" theme="simple" >
				</s:select>
		</div>
		<div class="grid_24">
			<ul class="gallery">
				<s:iterator value="imageSpecials" status="vs">
					<li class="image-item">
					<a href="pics.do?id=<s:property value="id"/>"><img src="<s:property value="image.path"/>" alt="图片">
					</a>
					<a href="pics.do?id=<s:property value="id"/>"><s:property value="name"/></a>
					</li>
				</s:iterator>
			</ul>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



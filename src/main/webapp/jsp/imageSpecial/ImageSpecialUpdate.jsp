<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" imageSpecial="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/admin.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('#imageSpecialList').addClass("active");
});
</script>
</head>
<body>
  <%@include file="./../Head.jsp"%>
  </br>
  </br>
  <div class="container-fluid">
    <div class="row-fluid">
      <%@include file="./../Menu.jsp"%>
      <div class="span10">
			<h4 style="text-align:center">修改高尔夫图片专题信息</h4>
				<form action="imageSpecialUpdateSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="imageSpecial.id" value="<s:property value="imageSpecial.id"/>"/>
					<tr>
						<td width="15%" class="left">一级分类<span style='color: red'>*</span></td>
						<td class="right"><s:select name="imageSpecial.categoryId"
								onchange="categoryChanged()" 
								list="categoryList" listKey="id" listValue="name"
								value="imageSpecial.categoryId" theme="simple" cssClass="select">
							</s:select></td>
					</tr>
					<tr>
						<td width="15%" class="left">二级分类<span style='color: red'>*</span></td>
						<td class="right"><s:select name="imageSpecial.smallCategoryId" 
								list="smallCategoryList" listKey="id" listValue="name"
								value="imageSpecial.smallCategoryId" theme="simple" cssClass="select">
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">专题名称<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="imageSpecial.name" value="<s:property value="imageSpecial.name"/>"/></td>
					</tr>
					<tr>
						<td class="left">专题说明<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="imageSpecial.content"  rows="5" cols="80"><s:property value="imageSpecial.content"/></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">专题封面<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							<s:if test="imageSpecial.imageId>0">图片名称:&nbsp;&nbsp; <s:property value='imageSpecial.image.name'/></s:if>
							<s:else>未上传图片</s:else></td>
					</tr>
					<tr>
						<td class="left">封面图片</td>
						<td class="right">
							<img src="<s:property value="imageSpecial.image.path"/>" style="width:200px;height:200px">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn">提交</button>
					</tr>
					</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


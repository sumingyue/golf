<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

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
$(document).ready(function() {
	$('#imageSpecialList').addClass("active");
	$("#form").validate({
		rules : {
			"imageSpecial.name" : {
				required : true
			},"imageSpecial.cotent" : {
				required : true
			},"upload" : {
				required : true
			}
		},
		messages : {
			"imageSpecial.name" : {
				required : "请输入专题名称"
			},"imageSpecial.cotent" : {
				required : "请输入专题介绍"
			},"upload" : {
				required : "请上传专题图片"
			}
		}
	});
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
			<h4 style="text-align:center">新增高尔夫图片专题信息</h4>
			<form action="imageSpecialAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td width="30%" class="left">一级分类<span style='color: red'>*</span></td>
						<td class="right"><s:select name="imageSpecial.categoryId"
								onchange="imageCategoryChanged()"
								list="categoryList" listKey="id" listValue="name"
								value="categoryId" theme="simple" cssClass="select">
							</s:select></td>
					</tr>
					<tr>
						<td class="left">二级分类<span style='color: red'>*</span></td>
						<td class="right">
						<s:select name="imageSpecial.smallCategoryId" 
								list="smallCategoryList" listKey="id" listValue="name"
								value="smallCategoryId"  theme="simple" cssClass="select">
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">专题名称<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="imageSpecial.name" /></td>
					</tr>
					<tr>
						<td class="left">专题说明<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="imageSpecial.content"  rows="5" cols="80"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">专题封面<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
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


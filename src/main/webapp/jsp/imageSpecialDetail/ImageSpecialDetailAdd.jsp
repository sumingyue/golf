<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" imageSpecialDetail="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#imageSpecialDetailList').addClass("active");
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
			<h4 style="text-align:center">新增高尔夫专题图片信息</h4>
			<form action="imageSpecialDetailAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="40%">专题名称<span style='color: red'>*</span></td>
						<td class="right">
							<s:select name="imageSpecialDetail.imageSpecialId" id="imageSpecialId"
								list="imageSpecials" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td class="left">图片简介<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="imageSpecialDetail.imageDes"  rows="5" cols="60"></textarea>
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


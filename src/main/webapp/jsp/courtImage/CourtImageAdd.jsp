<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtImage="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#courtImageList').addClass("active");
		$("#form").validate({
			rules : {
				"upload" : {
					required : true
				},
			},
			messages : {
				"upload" : {
					required : "请上传图片信息"
				},
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
			<h4 style="text-align:center">新增高尔夫球场图片信息</h4>
			<form action="courtImageAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="4" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="40%" colspan="2">球场<span style='color: red'>*</span></td>
						<td class="right" colspan="2">
							<s:select name="courtImage.courtId" id="courtId"
								list="courts" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">球场图片01<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介01</td>
						<td class="right"><textarea  name="des"  rows="3" cols="60"></textarea></td>
					</tr>
					<tr>
						<td class="left">球场图片02<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介02</td>
						<td class="right"><textarea  name="des"  rows="3" cols="60"></textarea></td>
					</tr>
					<tr>
						<td class="left">球场图片03<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介03</td>
						<td class="right"><textarea  name="des"  rows="3" cols="60"></textarea></td>
					</tr>
					<tr>
						<td class="left">球场图片04<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介04</td>
						<td class="right"><textarea  name="des"  rows="3" cols="60"></textarea></td>
					</tr>
					<tr>
						<td class="left">球场图片05<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介05</td>
						<td class="right"><textarea  name="des"  rows="3" cols="60"></textarea></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
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


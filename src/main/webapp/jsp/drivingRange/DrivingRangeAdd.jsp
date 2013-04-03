<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" drivingRange="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#drivingRangeList').addClass("active");
		
		$("#form").validate({
			rules : {
				"drivingRange.name" : {
					required : true
				},"drivingRange.introduction" : {
					required : true
				},"upload" : {
					required : true
				},"drivingRange.address" : {
					required : true
				},"drivingRange.phone" : {
					required : true
				}
			},
			messages : {
				"drivingRange.name" : {
					required : "请输入练习场名称"
				},"drivingRange.introduction" : {
					required : "请输入练习场说明"
				},"upload" : {
					required : "请上传练习场地图"
				},"drivingRange.address" : {
					required : "请输入练习场地址"
				},"drivingRange.phone" : {
					required : "请输入练习场联系方式"
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
			<form action="drivingRangeAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr>
						<th colspan="2"><h4 style="text-align:center">新增高尔夫练习场信息</h4></th>
					</tr>
					<tr>
						<td class="left" width="10%">练习场名称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="drivingRange.name" /></td>
					</tr>
					<tr>
						<td class="left">练习场地址<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="drivingRange.address" /></td>
					</tr>
					<tr>
						<td class="left">练习场电话<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="drivingRange.phone" /></td>
					</tr>
					<tr>
						<td class="left">练习场说明<span class='red'>*</span></td>
						<td class="right"><textarea  name="drivingRange.introduction"  rows="10" cols="120"></textarea>
						</td>
					</tr>
					<tr>
						<td  class="left">练习场图片<span class='red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center">
							<button type="submit" class="btn btn-primary  btn-large" >提交</button>
					</tr>
					</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


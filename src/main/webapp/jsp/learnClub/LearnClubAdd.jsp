<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" learnClub="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#learnClubList').addClass("active");
		
		$("#form").validate({
			rules : {
				"learnClub.name" : {
					required : true
				},"learnClub.introduction" : {
					required : true
				},"upload" : {
					required : true
				},"learnClub.address" : {
					required : true
				},"learnClub.phone" : {
					required : true
				}
			},
			messages : {
				"learnClub.name" : {
					required : "请输入学球机构名称"
				},"learnClub.introduction" : {
					required : "请输入学球机构说明"
				},"upload" : {
					required : "请上传学球机构地图"
				},"learnClub.address" : {
					required : "请输入学球机构地址"
				},"learnClub.phone" : {
					required : "请输入学球机构联系方式"
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
			<form action="learnClubAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr>
						<th colspan="2"><h4 style="text-align:center">新增高尔夫学球机构信息</h4></th>
					</tr>
					<tr>
						<td class="left" width="10%">学球机构名称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="learnClub.name" /></td>
					</tr>
					<tr>
						<td class="left">学球机构地址<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="learnClub.address" /></td>
					</tr>
					<tr>
						<td class="left">学球机构电话<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="learnClub.phone" /></td>
					</tr>
					<tr>
						<td class="left">学球机构说明<span class='red'>*</span></td>
						<td class="right"><textarea  name="learnClub.introduction"  rows="10" cols="120"></textarea>
						</td>
					</tr>
					<tr>
						<td  class="left">学球机构图片<span class='red'>*</span></td>
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


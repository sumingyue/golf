<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" court="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#courtList').addClass("active");
		
		$("#form").validate({
			rules : {
				"court.name" : {
					required : true
				},"court.introduction" : {
					required : true
				},"court.customIntro" : {
					required : true
				},"court.awards" : {
					required : true
				},"court.mapIntroduction" : {
					required : true
				},"upload" : {
					required : true
				},"court.address" : {
					required : true
				},"court.phone" : {
					required : true
				}
			},
			messages : {
				"court.name" : {
					required : "请输入俱乐部名称"
				},"court.introduction" : {
					required : "请输入俱乐部说明"
				},"court.customIntro" : {
					required : "请输入俱乐部介绍"
				},"court.awards" : {
					required : "请输入俱乐部奖项"
				},"court.mapIntroduction" : {
					required : "请输入行程路线"
				},"upload" : {
					required : "请上传俱乐部地图"
				},"court.address" : {
					required : "请输入俱乐部地址"
				},"court.phone" : {
					required : "请输入俱乐部联系方式"
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
			<form action="courtAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='2'>
						<h4 style="text-align:center">新增高尔夫俱乐部信息</h4>
					</td></tr>
					<tr>
						<td class="left" width="15%">俱乐部名称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="court.name" /></td>
					</tr>
					<tr>
						<td class="left">俱乐部地址<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="court.address" /></td>
					</tr>
					<tr>
						<td class="left">联系方式<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="court.phone" /></td>
					</tr>
					<tr>
						<td class="left">俱乐部说明<span class='red'>*</span></td>
						<td class="right"><textarea  name="court.introduction"  rows="5" cols="80"></textarea>
						</td>
					</tr>
					<tr>
						<td  class="left">俱乐部介绍<span class='red'>*</span></td>
						<td class="right"><textarea id="editor1" name="court.customIntro"
								rows="30"></textarea></td>
					</tr>
					<tr>
						<td  class="left">俱乐部奖项<span class='red'>*</span></td>
						<td class="right"><textarea id="editor2" name="court.awards"
								rows="30"></textarea></td>
					</tr><tr>
						<td  class="left">地图图片<span class='red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td class="left">行车路线<span class='red'>*</span></td>
						<td class="right"><textarea  name="court.mapIntroduction"  rows="6" cols="80"></textarea>
						</td>
					</tr>
						<tr>
							<td colspan="2" style="text-align:center">
								<button type="submit" class="btn btn-primary  btn-large">提交</button>
						</tr>
					</table>
					<ckeditor:replace replace="editor1" basePath="ckeditor/" />
					<ckeditor:replace replace="editor2" basePath="ckeditor/" />
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


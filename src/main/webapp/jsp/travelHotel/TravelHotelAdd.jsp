<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" travelHotel="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#travelHotelList').addClass("active");
		
		$("#form").validate({
			rules : {
				"travelHotel.name" : {
					required : true
				},"travelHotel.province" : {
					required : true
				},"travelHotel.city" : {
					required : true
				},"travelHotel.des" : {
					required : true
				}
			},
			messages : {
				"travelHotel.name" : {
					required : "请输入旅游酒店名称"
				},"travelHotel.province" : {
					required : "请输入旅游酒店所在省"
				},"travelHotel.city" : {
					required : "请输入旅游酒店所在市"
				},"travelHotel.des" : {
					required : "请输入旅游酒店介绍"
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
			<form action="travelHotelAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr>
						<th colspan="2"><h4 style="text-align:center">新增高尔夫旅游酒店信息</h4></th>
					</tr>
					<tr>
						<td class="left" width="10%">旅游酒店名称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="travelHotel.name" /></td>
					</tr>
					<tr>
						<td class="left">旅游酒店省<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="travelHotel.province" /></td>
					</tr>
					<tr>
						<td class="left">旅游酒店市<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="travelHotel.city" /></td>
					</tr>
					<tr>
						<td class="left">旅游酒店介绍<span class='red'>*</span></td>
						<td class="right"><textarea  name="travelHotel.des"  rows="10" cols="120"></textarea>
						</td>
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


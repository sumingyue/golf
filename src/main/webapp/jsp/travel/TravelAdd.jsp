<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" travel="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#travelList').addClass("active");
		
		$("#form").validate({
			rules : {
				"travel.name" : {
					required : true
				},"travel.price" : {
					required : true,
					number : true
				},"travel.prePrice" : {
					required : true,
					number : true
				},"travel.cashPrice" : {
					required : true,
					number : true
				},"travel.introduction" : {
					required : true
				},"travel.des" : {
					required : true
				}
			},
			messages : {
				"travel.name" : {
					required : "请输入旅游套餐名称"
				},"travel.price" : {
					required : "请输入总价格",
					number : "价格必须是数字"
				},"travel.prePrice" : {
					required : "请输入预付价格",
					number : "价格必须是数字"
				},"travel.cashPrice" : {
					required : "请输入现付价格",
					number : "价格必须是数字"
				},"travel.introduction" : {
					required : "请输入基本介绍"
				},"travel.des" : {
					required : "请输入备注事项"
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
			<form action="travelAddSubmit.do" id="form" method="post" 
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr>
						<th colspan="2"><h4 style="text-align:center">新增高尔夫旅游信息</h4></th>
					</tr>
					<tr>
						<td class="left" width="20%">旅游套餐名称<span class='red'>*</span></td>
						<td><input type="text" size="40" name="travel.name" /></td>
					</tr>
					<tr>
						<td class="left">球场选择<span class='red'>*</span></td>
						<td>
							<s:checkboxlist list="courts"
								listKey="id" listValue="name" name="courtSelected" theme="simple">
							</s:checkboxlist>
						</td>
					</tr>
					<tr>
						<td class="left">旅游套餐类型<span class='red'>*</span></td>
						<td>
							<select name="travel.type" id="type">
								<option value="1">休闲旅游</option>
								<option value="2">品质旅游</option>
								<option value="3">挑战旅游</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="left">旅游介绍<span class='red'>*</span></td>
						<td><textarea  name="travel.introduction"  rows="6" cols="120"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">酒店选择<span class='red'>*</span></td>
						<td>
							<s:select name="travel.travelHotelId"
								list="travelHotels" listKey="id" listValue="name"
								value="id" theme="simple" cssClass="select">
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">旅游价格（元/人）<span class='red'>*</span></td>
						<td><input type="text" size="40" name="travel.price" /></td>
					</tr>
					<tr>
						<td class="left">旅游预付（元/人）<span class='red'>*</span></td>
						<td><input type="text" size="40" name="travel.prePrice" /></td>
					</tr>
					<tr>
						<td class="left">旅游现金（元/人）<span class='red'>*</span></td>
						<td><input type="text" size="40" name="travel.cashPrice" /></td>
					</tr>
					<tr>
						<td class="left">备注事项<span class='red'>*</span></td>
						<td><textarea  name="travel.des"  rows="6" cols="120"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center">
							<button type="submit" class="btn btn-primary  btn-large">提交</button>
					</tr>
					</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


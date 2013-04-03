<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" travelPlan="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#travelPlanList').addClass("active");
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
			<form action="travelPlanAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='6'>
						<h4 style="text-align:center">新增高尔夫旅游行程安排信息</h4>
					</td></tr>
					<tr>
						<td class="left"  colspan="6">旅游套餐<span class='red'>*</span>
						
							<s:select name="travelId" id="travelId"
								list="travels" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">行程安排01<span class='red'>*</span></td>
						<td class="right"><input  type="text" name="names" placeholder="第一天"/></td>
						<td class="left">安排介绍01</td>
						<td class="right"><textarea  name="contents"  rows="3" cols="50"></textarea></td>
						<td class="left">安排备注01</td>
						<td class="right"><textarea  name="des"  rows="3" cols="50"></textarea></td>
					</tr>
					<tr>
						<td class="left">行程安排02<span class='red'>*</span></td>
						<td class="right"><input  type="text" name="names" placeholder="第二天"/></td>
						<td class="left">安排介绍02</td>
						<td class="right"><textarea  name="contents"  rows="3" cols="50"></textarea></td>
						<td class="left">安排备注02</td>
						<td class="right"><textarea  name="des"  rows="3" cols="50"></textarea></td>
					</tr>
					<tr>
						<td class="left">行程安排03<span class='red'>*</span></td>
						<td class="right"><input  type="text" name="names" placeholder="第三天"/></td>
						<td class="left">安排介绍03</td>
						<td class="right"><textarea  name="contents"  rows="3" cols="50"></textarea></td>
						<td class="left">安排备注03</td>
						<td class="right"><textarea  name="des"  rows="3" cols="50"></textarea></td>
					</tr>
					<tr>
						<td class="left">行程安排04<span class='red'>*</span></td>
						<td class="right"><input  type="text" name="names" placeholder="第四天"/></td>
						<td class="left">安排介绍04</td>
						<td class="right"><textarea  name="contents"  rows="3" cols="50"></textarea></td>
						<td class="left">安排备注04</td>
						<td class="right"><textarea  name="des"  rows="3" cols="50"></textarea></td>
					</tr>
					<tr>
						<td class="left">行程安排05<span class='red'>*</span></td>
						<td class="right"><input  type="text" name="names" placeholder="第五天"/></td>
						<td class="left">安排介绍05</td>
						<td class="right"><textarea  name="contents"  rows="3" cols="50"></textarea></td>
						<td class="left">安排备注05</td>
						<td class="right"><textarea  name="des"  rows="3" cols="50"></textarea></td>
					</tr>
					<tr>
						<td colspan="6" style="text-align:center">
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


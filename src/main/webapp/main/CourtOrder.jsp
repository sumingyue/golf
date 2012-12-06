<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>苏州高尔夫网</title>
<link rel="stylesheet" href="css/base.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<style type="text/css">
.left{
	text-align:right;
}
</style>
<script type="text/javascript">
	var calendar =null;
$(document).ready(function() {
	$('#courtOrderList').addClass("active");
	$("#form").validate({
		rules : {
			"courtOrder.courtName" : {
				required : true
			},"courtOrder.userName" : {
				required : true
			},"courtOrder.userPhone" : {
				required : true,
				digits: true
			},"courtOrder.number" : {
				required : true,
				digits: true
			},"courtOrder.date" : {
				required : true,
				date : true
			}
		},
		messages : {
			"courtOrder.courtName" : {
				required : "请输入练习场（球场）名字"
			},"courtOrder.userName" : {
				required : "请输入用户名"
			},"courtOrder.userPhone" : {
				required : "请输入电话号码",
				digits: "请输入正确的电话号码"
			},"courtOrder.number" : {
				required : "请输入订场人数",
				digits: "请输入正确的订场人数"
			},"courtOrder.date" : {
				required : "请输入订场日期",
				date : "请输入正确的订场日期"
			}
		}
	});
});
</script>
</head>
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_24">
			<div class="span10">
				<h2 align="center" style="color:#666;font-size:16px">订球场</h2>
				<form action="orderCourtSub.do" id="form" method="post">
					<table align="center" cellpadding="2" cellspacing="1" width="100%">
						<tr>
							<td class="left" width="40%">分类</td>
							<td ><select name="courtOrder.type">
									<option value="0">球场</option>
									<option value="1">练习场</option>
							</select></td>
						</tr>
						<tr>
							<td class="left" width="40%">球场名称<span style='color: red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.courtName" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">时间(10/10/2012)<span style='color: red'>*</span></td>
							<td ><input type="text" size="30"
								name="courtOrder.date" id="courtOrder.date" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">顾客姓名<span style='color: red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.userName" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">订场人数<span style='color: red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.number" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">顾客电话<span style='color: red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.userPhone" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">备注信息</td>
							<td ><textarea name="courtOrder.note" rows="4"
									cols="60"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="submit" class="btn">提交</button>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



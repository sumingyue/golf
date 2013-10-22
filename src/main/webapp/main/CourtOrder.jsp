<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	var calendar =null;
$(document).ready(function() {
	$('#service').addClass("active");
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
				required : true
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
			}
		}
	});
});
</script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li>当前位置：</li>
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
			<li class="active">球场预定</li>
		</ul>
	</div>
	<div class="row">
			<div class="span12">
				<form action="orderCourtSub.do" id="form" method="post">
					<table class="table table-striped table-bordered" width="100%">
						<tr>
							<td width="20%">分类</td>
							<td ><select name="courtOrder.type">
									<option value="0">球场</option>
									<option value="1">练习场</option>
							</select></td>
							<td width="20%">球场名称<span class='red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.courtName" /></td>
						</tr>
						<tr>
							<td width="20%">订场时间<span class='red'>*</span></td>
							<td ><input type="text" size="30"
								name="courtOrder.date" id="courtOrder.date" />
								&nbsp;
								<img src="img/calendar.gif"
								onclick="showCalendar('courtOrder.date');"></td>
							<td width="20%">订场人数<span class='red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.number" /></td>
						</tr>
						<tr>
							<td width="20%">顾客姓名<span class='red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.userName" /></td>
							<td width="20%">顾客电话<span class='red'>*</span></td>
							<td ><input type="text" size="40"
								name="courtOrder.userPhone" /></td>
						</tr>
						<tr>
							<td width="20%">备注信息</td>
							<td ><textarea name="courtOrder.note" rows="4"
									cols="40"></textarea></td>
							<td colspan="2" style="text-align:center;vertical-align:middle">
								<button type="submit" class="btn btn-primary">提交</button>
						</tr>
					</table>
				</form>
		</div></div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>





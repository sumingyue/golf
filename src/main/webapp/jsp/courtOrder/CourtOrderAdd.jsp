<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
var calendar=null;
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
<body>
	<%@include file="./../Head.jsp"%>
	</br>
	</br>
	<div class="container-fluid">
		<div class="row-fluid">
			<%@include file="./../Menu.jsp"%>
			<div class="span10">
				<form action="courtOrderAddSubmit.do" id="form" method="post">
					<table class="table table-striped table-bordered">
						<tr><td colspan='2'>
							<h4 style="text-align:center">新增球场预定信息</h4>
						</td></tr>
						<tr>
							<td class="left" width="40%">分类</td>
							<td class="right"><select name="courtOrder.type">
									<option value="0">球场</option>
									<option value="1">练习场</option>
							</select></td>
						</tr>
						<tr>
							<td class="left" width="40%">球场名称<span class='red'>*</span></td>
							<td class="right"><input type="text" size="40"
								name="courtOrder.courtName" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">订场时间<span class='red'>*</span></td>
							<td class="right"><input type="text" size="30"
								name="courtOrder.date" id="courtOrder.date" /> <img
								src="img/calendar.gif"
								onclick="showCalendar('courtOrder.date');"></td>
						</tr>
						<tr>
							<td class="left" width="40%">顾客姓名<span class='red'>*</span></td>
							<td class="right"><input type="text" size="40"
								name="courtOrder.userName" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">订场人数<span class='red'>*</span></td>
							<td class="right"><input type="text" size="40"
								name="courtOrder.number" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">顾客电话<span class='red'>*</span></td>
							<td class="right"><input type="text" size="40"
								name="courtOrder.userPhone" /></td>
						</tr>
						<tr>
							<td class="left" width="40%">备注信息</td>
							<td class="right"><textarea name="courtOrder.note" rows="4"
									cols="40"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align:center">
								<button type="submit" class="btn btn-primary  btn-small" >提交</button>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@include file="./../Foot.jsp"%>
	</div>
</body>
</html>

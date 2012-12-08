<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" matchService="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
var calendar = null;
$(document).ready(function() {
	$('#matchServiceList').addClass("active");
	$("#form").validate({
		rules : {
			"matchService.number" : {
				required : true,
				number : true
			},"matchService.date" : {
				required : true,
				date : true
			},"matchService.userName" : {
				required : true
			},"matchService.userPhone" : {
				required : true,
				number : true
			}
		},
		messages : {
			"matchService.number" : {
				required : "请输入比赛人数",
				number : "请输入正确的比赛人数"
			},"matchService.date" : {
				required : "请输入比赛日期",
				date : "请输入正确的比赛日期"
			},"matchService.userName" : {
				required : "请输入用户名"
			},"matchService.userPhone" : {
				required : "请输入联系方式",
				number : "请输入正确的联系方式"
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
			<h4 style="text-align:center">新增赛事服务信息</h4>
			<form action="matchServiceAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="40%">比赛人数<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.number" /></td>
					</tr>
					<tr>
						<td class="left">比赛时间<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" id="matchService.date" name="matchService.date" />
						  &nbsp;&nbsp;&nbsp;&nbsp;<img src="img/calendar.gif"
								onclick="showCalendar('matchService.date');"></td>
					</tr>
					<tr>
						<td class="left">客户姓名<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userName" /></td>
					</tr>
					<tr>
						<td class="left">联系方式<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userPhone" /></td>
					</tr>
					<tr>
							<td class="left">备注信息&nbsp;&nbsp;</td>
							<td class="right"><textarea name="matchService.content" rows="7"
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
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


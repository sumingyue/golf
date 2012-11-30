<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
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
$(document).ready(function(){
	$('#matchServiceList').addClass("active");
	var type = <s:property value='matchService.status'/>;
	$('#matchService_status').attr("value",type);
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
			<h4 style="text-align:center">修改赛事服务信息</h4>
			<form action="matchServiceUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="matchService.id" value="<s:property value="matchService.id"/>"/>
					<tr>
						<td class="left">比赛人数<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.number" value="<s:property value="matchService.number"/>"/></td>
					</tr>
					<tr>
						<td class="left">比赛时间<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" id="matchService.date" name="matchService.date"  value="<s:property value="matchService.date"/>"/>
						  &nbsp;&nbsp;&nbsp;&nbsp;<img src="img/calendar.gif"
								onclick="showCalendar('matchService.date');"></td>
					</tr>
					<tr>
						<td class="left">客户姓名<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userName" value="<s:property value="matchService.userName"/>"/></td>
					</tr>
					<tr>
						<td class="left">联系方式<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userPhone" value="<s:property value="matchService.userPhone"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="40%">备注信息&nbsp;&nbsp;</td>
						<td class="right"><textarea name="matchService.content" rows="4"
								cols="60"><s:property value="matchService.content"/></textarea></td>
					</tr>
					<tr>
							<td class="left" width="40%">订单状态<span style='color: red'>*</span></td>
							<td class="right"><select name="matchService.status"
								id="courtOrder_status">
									<option value="0">未处理</option>
									<option value="1">待处理</option>
									<option value="2">已处理</option>
							</select></td>
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


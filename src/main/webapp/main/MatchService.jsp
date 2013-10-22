<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
var calendar = null;
$(document).ready(function() {
	$('#service').addClass("active");
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
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li>当前位置：</li>
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
			<li class="active">赛事服务</li>
		</ul>
	</div>
	<div class="row">
	<div class="span12">
			<form action="matchServiceSub.do" id="form" method="post">
				<table class="table table-striped table-bordered">
					<tr>
						<td >比赛人数<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.number" /></td>
						<td>比赛时间<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" id="matchService.date" name="matchService.date" />
						  &nbsp;&nbsp;&nbsp;&nbsp;<img src="img/calendar.gif"
								onclick="showCalendar('matchService.date');"></td>
					</tr>
					<tr>
						<td>客户姓名<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userName" /></td>
						<td>联系方式<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="matchService.userPhone" /></td>
					</tr>
					<tr>
							<td>备注信息&nbsp;&nbsp;</td>
							<td class="right"><textarea name="matchService.content" rows="7"
									cols="40"></textarea></td>
							<td colspan="2" style="text-align:center;vertical-align:middle">
								<button type="submit" class="btn btn-primary">提交</button>
					</tr>
					</table>
			</form>
			<br>
				<table class="table table-striped table-bordered table-hover">
					<tr><td>项目</td><td>说明</td></tr>
					<tr><td>比赛礼品</td><td>高尔夫球,球手所需的高尔夫球衣,帽子</td></tr>
					<tr><td>场地布置</td><td>欢迎横幅、空飘汽球、双龙拱门、背景板、投影机、屏幕、抽奖箱、彩旗、记分板、指示牌、比赛杂物等</td></tr>
					<tr><td>奖杯奖品</td><td>净杆组奖杯、总杆组奖杯、特别奖项奖杯、抽奖奖品</td></tr>
					<tr><td>餐饮服务</td><td>午餐、晚餐</td></tr>
					<tr><td>其他服务</td><td>摄影师、主持人、礼仪小姐、迎宾花篮、贵宾胸花、协助预订酒店、机票、汽车</td></tr>
				</table>
		</div></div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>






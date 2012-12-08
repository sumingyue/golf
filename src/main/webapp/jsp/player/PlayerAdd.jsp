<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#playerList').addClass("active");
	$("#form").validate({
		rules : {
			"player.name" : {
				required : true
			},"player.score" : {
				required : true,
				number : true
			},"player.bonus" : {
				required : true,
				number : true
			}
		},
		messages : {
			"player.name" : {
				required : "请输入球员姓名"
			},"player.score" : {
				required : "请输入积分",
				number : "请输入正确的积分"
			},"player.bonus" : {
				required : "请输入奖金",
				number : "请输入正确的奖金"
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
			<h4 style="text-align:center">新增球员信息</h4>
			<form action="playerAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1"  width="100%">
					<tr>
						<td width="35%" class="left">球员姓名</td>
						<td class="right"><input type="text" size="40" name="player.name" /></td>
					</tr>
					<tr>
						<td class="left">球员积分</td>
						<td class="right"><input type="text" size="40" name="player.score" /></td>
					</tr>
					<tr>
						<td class="left">球员奖金</td>
						<td class="right"><input type="text" size="40" name="player.bonus" /></td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>



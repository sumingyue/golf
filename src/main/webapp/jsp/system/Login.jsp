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
		$('#adwordsList').addClass("active");
		$("#form").validate({
			rules : {
				"user.name" : {
					required : true
				},
				"user.password" : {
					required : true
				}
			},
			messages : {
				"user.name" : {
					required : "请输入用户名"
				},
				"user.password" : {
					required : "请输入用户密码"
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
			<h4 style="text-align:center"></h4>
     			<form action="loginSub.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td  width="30%" class="left">用户名<span class='red'>*</span></td>
						<td class="right"><input type="text" size="60" name="user.userName" /></td>
					</tr>
					<tr>
						<td class="left">密码<span class='red'>*</span></td>
						<td class="right"><input type="password" size="60" name="user.password" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input name="submint" type="submit" class="inputSubmit" value="提    交"/></td>
					</tr>
				</table>
		</div>
		<%@include file="./../Foot.jsp"%>
	</div>
</body>
</html>

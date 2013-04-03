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
	$('#userMessageList').addClass("active");
	$("#form").validate({
		rules : {
			"userMessage.content" : {
				required : true
			},
		},
		messages : {
			"userMessage.content" : {
				required : "请输入留言内容"
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
				<form action="userMessageAddSubmit.do" id="form" method="post">
				<table class="table table-striped table-bordered" width="100%">
						<h4 style="text-align:center">新增用户留言信息</h4>
					</td></tr>
					<tr>
						<td class="left" width="40%">用户留言</td>
						<td class="right"><textarea  name="userMessage.content"  rows="5" cols="80"></textarea>
						</td>
					</tr><tr><td colspan="2" style="text-align:center"><button type="submit" class="btn btn-primary  btn-large" >提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


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
	$('#mediaList').addClass("active");
	$("#form").validate({
		rules : {
			"media.name" : {
				required : true
			},"media.url" : {
				required : true,
				url : true
			}
		},
		messages : {
			"media.name" : {
				required : "请输入媒体名称"
			},"media.url" : {
				required : "请输入合作链接",
				url : "请输入正确的链接"
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
			<h4 style="text-align:center">新增媒体链接信息</h4>
			<form action="mediaAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="30%">分类</td>
						<td class="right">
							<select name="media.type">
									<option value="合作媒体">合作媒体</option>
									<option value="友情链接">友情链接</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="left">名称</td>
						<td class="right"><input type="text" size="40" name="media.name" /></td>
					</tr>
					<tr>
						<td class="left">链接</td>
						<td class="right"><input type="text" size="80" name="media.url" /></td>
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


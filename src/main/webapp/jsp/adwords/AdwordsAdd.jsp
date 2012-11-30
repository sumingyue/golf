<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
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
				"adwords.position" : {
					required : true
				},
				"adwords.name" : {
					required : true
				},
				"adwords.width" : {
					required : true,
					range: [1,1000]
				},
				"adwords.height" : {
					required : true,
					range: [1,500]
				},
				"adwords.url" : {
					required : true,
					url :true
				}
			},
			messages : {
				"adwords.position" : {
					required : "请输入广告位置"
				},
				"adwords.name" : {
					required : "请输入广告名称"
				},
				"adwords.width" : {
					required : "请输入广告宽度",
					range: "广告宽度第在1-1000之间"
				},
				"adwords.height" : {
					required : "请输入广告高度",
					range: "广告高度第在1-500之间"
				},
				"adwords.url" : {
					required : "请输入广告链接",
					url :"请输入正确的链接"
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
      	<h4 style="text-align:center">新增广告信息</h4>
        <form action="adwordsAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td  width="30%" class="left">广告位置</td>
						<td class="right"><input type="text" size="60" name="adwords.position" /></td>
					</tr>
					<tr>
						<td class="left">广告名称</td>
						<td class="right"><input type="text" size="60" name="adwords.name" /></td>
					</tr>
					<tr>
						<td class="left">广告宽度</td>
						<td class="right"><input type="text" size="40" name="adwords.width" /></td>
					</tr>
					<tr>
						<td class="left">广告高度</td>
						<td class="right"><input type="text" size="40" name="adwords.height" /></td>
					</tr>
					<tr>
						<td class="left">广告链接</td>
						<td class="right"><input type="text" size="80" name="adwords.url" /></td>
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

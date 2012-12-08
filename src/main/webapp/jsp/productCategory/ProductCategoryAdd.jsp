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
	$('#productCategoryList').addClass("active");
	$("#form").validate({
		rules : {
			"productCategory.name" : {
				required : true
			},
		},
		messages : {
			"productCategory.name" : {
				required : "请输入分类名称"
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
				<h4 style="text-align:center">新增产品分类信息</h4>
				<form action="productCategoryAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="40%">一级分类</td>
						<td class="right">
						<select name="productCategory.type">
									<option value="1">球具</option>
									<option value="2">服饰</option>
									<option value="3">用品</option>
									<option value="4">附件</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="left">分类名称</td>
						<td class="right"><input type="text" size="40" name="productCategory.name" /></td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

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
		$('#categoryList').addClass("active");

		$("#form").validate({
			rules : {
				"category.name" : {
					required : true
				},
			},
			messages : {
				"category.name" : {
					required : "请输入分类名称"
				},
			}

		});
		var type=<s:property value="category.type"/>;
		$('#category_type').val(type);
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
				<h4 style="text-align:center">编辑一级分类</h4>
				<form action="categoryUpdateSubmit.do" id="form" method="post">
					<table align="center" cellpadding="2" cellspacing="1" width="100%">
						<input type="hidden" name="category.id"
							value="<s:property value="category.id"/>" />
						<tr>
							<td width="40%" class="left">一级分类类型</td>
							<td width="60%" class="right">
							<select id="category_type" name="category.type">
								<option value="1">新闻分类</option>
								<option value="2">图片专题</option>
								<option value="3">商城商品</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="left">一级分类名称</td>
							<td class="right"><input type="text" size="40"
								name="category.name" value="<s:property value="category.name"/>" /></td>
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

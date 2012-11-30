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
	$('#smallCategoryList').addClass("active");
	$("#form").validate({
		rules : {
			"smallCategory.name" : {
				required : true
			},
		},
		messages : {
			"smallCategory.name" : {
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
     		 <h4 style="text-align:center">编辑新闻二级分类</h4>
			<form action="smallCategoryUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="smallCategory.id" value="<s:property value="smallCategory.id"/>"/>
					<tr>
						<td width="50%" class="left">一级分类名称</td>
						<td  class="right">
							<s:select  name="smallCategory.categoryId"  list="categories" listKey="id"
							listValue="name" value="smallCategory.categoryId" theme="simple">
							</s:select>
						</td>
					</tr>
					<tr>
						<td width="50%" class="left">二级分类名称</td>
						<td  class="right"><input type="text" size="40" name="smallCategory.name" 
						value="<s:property value="smallCategory.name"/>"/></td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


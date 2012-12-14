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
	$('#productList').addClass("active");
	$("#form").validate({
		rules : {
			"product.name" : {
				required : true
			},"product.unit" : {
				required : true
			},"product.brand" : {
				required : true
			},"product.crowd" : {
				required : true
			},"product.material" : {
				required : true
			},"product.introduction" : {
				required : true
			},"product.price" : {
				required : true,
				number: true
			},"product.memberPrice" : {
				required : true,
				number: true
			}
		},
		messages : {
			"product.name" : {
				required : "请输入产品名称"
			},"product.unit" : {
				required : "请输入产品单位"
			},"product.brand" : {
				required : "请输入产品品牌"
			},"product.crowd" : {
				required : "请输入适用人群"
			},"product.material" : {
				required : "请输入产品材质"
			},"product.introduction" : {
				required : "请输入产品介绍"
			},"product.price" : {
				required : "请输入产品价格",
				number: "请输入正确的价格"
			},"product.memberPrice" : {
				required : "请输入产品会员价",
				number: "请输入正确的产品会员价"
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
				<h4 style="text-align:center">新增商品信息</h4>
				<form action="productAddSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="10%" >产品分类<span style='color: red'>*</span></td>
						<td class="right" width="40%"  >
							<s:select name="product.productCategoryId"
								list="productCategorys" listKey="id" listValue="showName"
								value="categoryId" theme="simple" cssClass="select">
							</s:select>
						</td><td class="left" width="10%" >产品名称<span style='color: red'>*</span></td>
						<td class="right" width="40%" ><input type="text" size="40" name="product.name" /></td>
					</tr>
					<tr>
						<td class="left">产品单位<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.unit" /></td>
						<td class="left">产品品牌<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.brand" /></td>
					</tr>
					<tr>
						<td class="left">适合人群<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.crowd" /></td>
						<td class="left">产品材质<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.material" /></td>
					</tr>
					<tr>
						<td class="left">产品价格<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.price" /></td>
						<td class="left">会员价格<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.memberPrice" /></td>
					</tr>
					<tr>
						<td class="left">产品介绍<span style='color: red'>*</span></td>
						<td class="right" colspan='3'><textarea  name="product.introduction"  rows="4" cols="60"></textarea></td>
					</tr>
					<tr><td colspan="4" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


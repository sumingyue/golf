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
				<h4 style="text-align:center">修改商品信息</h4>
				<form action="productUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="product.id" value="<s:property value="product.id"/>"/>
					<tr>
						<td class="left" width="10%">产品分类<span class='red'>*</span></td>
						<td class="right" width="40%">
							<s:select name="product.productCategoryId"
								list="productCategorys" listKey="id" listValue="showName"
								value="product.productCategoryId" theme="simple" cssClass="select">
							</s:select>
						</td><td class="left" width="10%">产品名称<span class='red'>*</span></td>
						<td class="right"  width="40%"><input type="text" size="40" name="product.name"  value="<s:property value="product.name"/>"/></td>
					
					</tr>
					<tr>
						<td class="left" >产品单位<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.unit"  value="<s:property value="product.unit"/>"/></td>
						<td class="left" >产品品牌<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.brand"  value="<s:property value="product.brand"/>"/></td>
					</tr>
					<tr>
						<td class="left" >适合人群<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.crowd"  value="<s:property value="product.crowd"/>"/></td>
						<td class="left" >产品材质<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.material"  value="<s:property value="product.material"/>"/></td>
					</tr>
					<tr>
						<td class="left" >产品价格<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.price"  value="<s:property value="product.price"/>"/></td>
						<td class="left" >会员价格<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="product.memberPrice"  value="<s:property value="product.memberPrice"/>"/></td>
					</tr>
					
					<tr>
						<td class="left" >产品介绍<span class='red'>*</span></td>
						<td class="right" colspan="3" ><textarea  name="product.introduction"  rows="4" cols="40"><s:property value="product.introduction"/></textarea></td>
					</tr>
					<tr><td colspan="4" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
			<br>
				<h4 style="text-align:center">商品图片列表</h4>
				<table align="center" cellpadding="2" cellspacing="1" width="100%"
					width="100%">
				<s:iterator value="product.images" status="status">
					<s:if test="#status.index%5==0">
						<tr>
					</s:if>
					<td>
						<img src="<s:property value="path"/>">
						<a href='productImageDelete.do?productId=<s:property value="product.id"/>&imageId=<s:property value="id"/>'>删除</a>
					</td>
					<s:if test="#status.index%5==4||#status.last">
						</tr>
					</s:if>
				</s:iterator>
			</table>
			<br>
			<form action="productAddImageSubmit.do" id="form" method="post"
				enctype="multipart/form-data">
				<h4 style="text-align:center">新增商品图片</h4>
				<table align="center" cellpadding="2" cellspacing="1" width="100%"
					width="95%">
					<input type="hidden" name="product.id" value="<s:property value="product.id"/>"/>
					<tr>
						<td  class="left" width="50%">上传产品图片01</td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"/></td>
					</tr><tr>
						<td  class="left">上传产品图片02</td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"/></td>
					</tr><tr>
						<td  class="left">上传产品图片03</td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"/></td>
					</tr><tr>
						<td  class="left">上传产品图片04</td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"/></td>
					</tr><tr>
						<td  class="left">上传产品图片05</td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"/></td>
					</tr>
					<tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></td></tr>
				</table>
			</table></form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


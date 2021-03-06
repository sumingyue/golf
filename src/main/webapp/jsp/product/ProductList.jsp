<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
<link rel='stylesheet' type='text/css' href='css/table_jui.css' />
<script src="js/tableInit.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		init();
		$('#productList').addClass('active');
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
        		<!-- 	<h4 style="text-align:center">商城商品管理</h4> -->
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="contents">
				<thead><tr class="title">
					<th width="5%">序号</th>
					<th width="10%">
						一级分类
						<%-- <select id="product_type" onchange="typeChanged()">
							<option value="0">ALL</option>
							<option value="1">球具</option>
							<option value="2">服饰</option>
							<option value="3">用品</option>
							<option value="4">附件</option>
						</select> --%>
					</th>
					<th width="10%">
						二级分类
						<%-- <s:select name="product.productCategoryId"
								onchange="categoryChanged()"
								list="productCategorys" listKey="id" listValue="name"
								headerKey="0" headerValue="ALL"
								value="productCategoryId" theme="simple" >
						</s:select> --%>
					</th>
					<th width="45%">名称</th>
					<th width="10%">价格</th>
					<th width="10%">会员价</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="productAdd.do" >新增</a></th>
				</tr></thead><tbody>
				<s:iterator value="products" status="vs">
					<tr class="trDetail">
					<td><s:property value='#vs.index+1'/></td>
					<td>
						<s:if test="productCategory.type==1">球具</s:if>
						<s:elseif test="productCategory.type==2">服饰</s:elseif>
						<s:elseif test="productCategory.type==3">用品</s:elseif>
						<s:elseif test="productCategory.type==4">附件</s:elseif>
					</td>
					<td><s:property value="productCategory.name" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="price" /></td>
					<td><s:property value="memberPrice" /></td>
					<td><a href="productUpdate.do?productId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="productDelete.do?productId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator></tbody>
			</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


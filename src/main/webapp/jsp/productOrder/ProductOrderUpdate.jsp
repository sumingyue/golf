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
		var type = <s:property value='productOrder.status'/>;
		$('#productOrder_status').attr("value",type);
		$('#productOrderList').addClass("active");
		$("#form").validate({
			rules : {
				"productOrder.orderNumber" : {
					required : true,
					number: true
				},"productOrder.userName" : {
					required : true
				},"productOrder.userPhone" : {
					required : true,
					digits:true
				},"productOrder.userAddress" : {
					required : true
				}
			},
			messages : {
				"productOrder.orderNumber" : {
					required : "请输入订单数量",
					number: "请输入正确的订单数量"
				},"productOrder.userName" : {
					required : "请输入用户名"
				},"productOrder.userPhone" : {
					required : "请输入手机号码",
					digits: "请输入正确的手机号码"
				},"productOrder.userAddress" : {
					required : "请输入用户地址"
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
      		<h4 style="text-align:center">修改商品订购信息</h4>
			<form action="productOrderUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="productOrder.id" value="<s:property value="productOrder.id"/>"/>
					<tr>
						<td class="left" width="40%">商品ID</td>
						<td class="right">
							<input type="text" size="40" name="productOrder.productId"  value="<s:property value="productOrder.productId"/>"/>
						</td>
					</tr>
					<tr>
						<td class="left" width="40%">订单数量<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="productOrder.orderNumber"  value="<s:property value="productOrder.orderNumber"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="40%">顾客姓名<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="productOrder.userName"  value="<s:property value="productOrder.userName"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="40%">顾客电话<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="productOrder.userPhone"  value="<s:property value="productOrder.userPhone"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="40%">顾客地址<span class='red'>*</span></td>
						<td class="right"><input type="text" size="40" name="productOrder.userAddress"  value="<s:property value="productOrder.userAddress"/>"/></td>
					</tr>
					<tr>
						<td class="left" width="40%">订单状态<span class='red'>*</span></td>
						<td class="right">
						<select name="productOrder.status" id="productOrder_status">
							<option value="0">未处理</option>
							<option value="1">待处理</option>
							<option value="2">已处理</option>
						</select>
						</td>
					</tr>
					<tr>
						<td class="left" width="40%">备注信息<span class='red'>*</span></td>
						<td class="right"><textarea  name="productOrder.note"  rows="4" cols="60"><s:property value="productOrder.note"/></textarea></td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

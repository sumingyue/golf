<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>苏州高尔夫网</title>
	<link rel="stylesheet" href="css/base.css">
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<style type="text/css">
		.qalist li{margin-bottom:10px;padding-bottom:10px;}
		.qalist .question{color:#333;}
		.qalist .awanser{margin:10px;border:1px dashed #ccc;padding:5px;background:#f5f5f5;}
		.error{color:red;}
	</style>
	
<script type="text/javascript">
$(document).ready(function() {
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
<body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>
		<div class="clear"></div>
		<div class="grid_24">
			<form action="ums.do" id="form" method="post">
				<table width="100%" border="0" cellspacing="1" cellpadding="0">
					<tbody>
						<tr height="30">
							<td colspan="2" align="center"><font color="#006600"
								style="font-size: 14px; line-height: 22px"><b>签&nbsp;写&nbsp;留&nbsp;言</b></font>
							</td>
						</tr>
						<tr>
							<td height="30" align="center"><font style="font-size: 12px">咨询内容：</font></td>
							<td align="left" width="85%">&nbsp;<textarea
									name="userMessage.content" style="width: 95%; height: 100px;"></textarea></td>
						</tr>
						<tr>
							<td align="center" colspan="2"><button type="submit"
									class="btn">提&nbsp;&nbsp;交</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="clear"></div>
		<div class="grid_24">
			<ul class="qalist">
				<s:iterator value="userMessages" status="vs">
			<li>
					<p class="question"><strong>提问：</strong><s:property value="content"/> </p>
					<p class="awanser"><strong>回答：</strong><s:property value="reply"/> </p>
				</li>
			
			</s:iterator>	
			</ul>
			<div class="paginate">
				共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
						<a href="uml.do?index=0">首页</a>&nbsp;&nbsp;
						<a href="uml.do?index=<s:property value="pagedTool.pageIndex-1"/>">上一页</a>&nbsp;&nbsp;
						<a href="uml.do?index=<s:property value="pagedTool.pageIndex+1"/>">下一页</a>&nbsp;&nbsp;
						<a href="uml.do?index=<s:property value="pagedTool.totalPage"/>">末页</a>&nbsp;&nbsp;
						共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
						<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
			</div>
		</div>	
		
		<jsp:include page="./Foot.jsp"></jsp:include>
	</div>
</body>
</html>



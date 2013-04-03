<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li>当前位置：</li>
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
			<li class="active">用户留言</li>
		</ul>
		<table class="table table-striped table-bordered table-hover">
			<s:iterator value="userMessages" status="vs">
				<tr><td><strong>提问</strong></td><td><s:property value="content"/></td></tr>
				<tr><td><strong>回答</strong></td><td class="error"><s:property value="reply"/></td></tr>
			</s:iterator>
		</table>
	</div>
	</br>
	<form action="addMessage.do" id="form" method="post" class="message-form form">
				<table class="table table-striped table-bordered">
					<tbody>
						<tr height="30">
							<td colspan="2" style="text-align:center"><font color="#006600"
								style="font-size: 14px; line-height: 22px"><b>签&nbsp;写&nbsp;留&nbsp;言</b></font>
							</td>
						</tr>
						<tr>
							<td height="30" align="center"><font style="font-size: 12px">咨询内容：</font></td>
							<td align="left" width="85%">&nbsp;<textarea class="input"
									name="userMessage.content" style="width: 95%; height: 100px;"></textarea></td>
						</tr>
						<tr>
							<td align="center" colspan="2" style="text-align:center"><button type="submit"
									class="btn btn-primary">提&nbsp;&nbsp;交</button></td>
						</tr>
					</tbody>
				</table>
			</form>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>






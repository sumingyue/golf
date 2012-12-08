<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtComments="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#courtCommentsList').addClass("active");
		$("#form").validate({
			rules : {
				"courtComments.userName" : {
					required : true
				},
				"courtComments.content" : {
					required : true
				}
			},
			messages : {
				"courtComments.userName" : {
					required : "请输入昵称"
				},
				"courtComments.content" : {
					required : "请输入评论内容"
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
			<h4 style="text-align:center">新增高尔夫俱乐部评论信息</h4>
			<form action="courtCommentsAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="40%">俱乐部<span style='color: red'>*</span></td>
						<td class="right">
							<s:select name="courtComments.courtId" id="courtId"
								list="courts" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">用户昵称<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="30" name="courtComments.userName" /></td>
					</tr>
					<tr>
						<td class="left">用户评论<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="courtComments.content"  rows="5" cols="60"></textarea>
						</td>
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


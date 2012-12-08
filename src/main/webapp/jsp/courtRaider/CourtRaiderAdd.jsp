<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtRaider="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#courtRaiderList').addClass("active");
	$("#form").validate({
		rules : {
			"courtRaider.name" : {
				required : true
			},"courtRaider.indexName" : {
				required : true
			},"upload" : {
				required : true
			},"courtRaider.des" : {
				required : true
			}
		},
		messages : {
			"courtRaider.name" : {
				required : "请输入球道分类"
			},"courtRaider.indexName" : {
				required : "请输入球道顺序"
			},"upload" : {
				required : "请上传球道图片"
			},"courtRaider.des" : {
				required : "请输入球道介绍"
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
			<h4 style="text-align:center">新增高尔夫俱乐部球道信息</h4>
			<form action="courtRaiderAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<td class="left" width="30%">俱乐部<span style='color: red'>*</span></td>
						<td class="right">
							<s:select name="courtRaider.courtId" id="courtId"
								list="courts" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">球道分类<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="30" name="courtRaider.name" /></td>
					</tr>
					<tr>
						<td class="left">球道顺序<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="30" name="courtRaider.indexName" /></td>
					</tr>
					<tr>
						<td class="left">球道图片<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td class="left">球道简介<span style='color: red'>*</span></td>
						<td class="right"><textarea  name="courtRaider.des"  rows="6" cols="80"></textarea>
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


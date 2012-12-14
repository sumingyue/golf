<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtImage="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#courtImageList').addClass("active");
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
			<h4 style="text-align:center">修改高尔夫俱乐部球道信息</h4>
			<form action="courtImageUpdateSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<input type="hidden" name="courtImage.id" value="<s:property value="courtImage.id"/>"/>
						<td class="left" width="40%">球场<span style='color: red'>*</span></td>
						<td class="right">
							<s:select name="courtImage.courtId" id="courtId"
								list="courts" listKey="id" value="courtImage.courtId" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">更换图片<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							</td>	
						</td>
					</tr>
					<tr>
						<td class="left">图片样例<span style='color: red'>*</span></td>
						<td class="right">
							<img src="<s:property value="courtImage.image.path"/>" >
							<s:if test="courtImage.imageId>0">名称:&nbsp;&nbsp; <s:property value='courtImage.image.name'/></s:if>
							<s:else>未上传图片</s:else>
						</td>	
						</td>
					</tr>
					<tr>
						<td class="left">图片简介</td>
						<td class="right"><textarea  name="courtImage.imageDes"  rows="5" cols="60"><s:property value='courtImage.imageDes'/></textarea>
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


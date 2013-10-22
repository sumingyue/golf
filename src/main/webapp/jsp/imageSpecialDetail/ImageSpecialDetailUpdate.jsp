<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" imageSpecialDetail="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#imageSpecialDetailList').addClass("active");
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
			<form action="imageSpecialDetailUpdateSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='4'>
						<h4 style="text-align:center">修改高尔夫图片专题图片信息</h4>
					</td></tr>
					<tr>
						<input type="hidden" name="imageSpecialDetail.id" value="<s:property value="imageSpecialDetail.id"/>"/>
						<td class="left" width="40%">专题名称<span class='red'>*</span></td>
						<td class="right">
							<s:select name="imageSpecialDetail.imageSpecialId" id="imageSpecialId"
								list="imageSpecials" listKey="id" listValue="showName"  value="imageSpecialDetail.imageSpecialId" theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">修改图片<span class='red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							</td>	
						</td>
					</tr>
					<tr>
						<td class="left">图片样例<span class='red'>*</span></td>
						<td class="right">
							<img src="<s:property value="imageSpecialDetail.image.path"/>" >
							<s:if test="imageSpecialDetail.imageId>0">名称:&nbsp;&nbsp; <s:property value='imageSpecialDetail.image.name'/></s:if>
							<s:else>未上传图片</s:else>
						</td>	
						</td>
					</tr>
					<tr>
						<td class="left" width="30%">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="imageSpecialDetail.imageDes"  rows="5" cols="40"><s:property value='imageSpecialDetail.imageDes'/></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center">
							<button type="submit" class="btn btn-primary  btn-large">提交</button>
					</tr>
					</table>
			</form>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>


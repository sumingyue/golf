<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" travelHotelImage="screen">	
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#travelHotelImageList').addClass("active");
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
			<form action="travelHotelImageUpdateSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='2'>
						<h4 style="text-align:center">修改旅游酒店图片信息</h4>
					</td></tr><tr>
						<input type="hidden" name="travelHotelImage.id" value="<s:property value="travelHotelImage.id"/>"/>
						<td class="left" width="25%">球场<span class='red'>*</span></td>
						<td class="right">
							<s:select name="travelHotelImage.travelHotelId" id="travelHotelId"
								list="travelHotels" listKey="id" value="travelHotelImage.travelHotelId" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">更换图片<span class='red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							</td>	
						</td>
					</tr>
					<tr>
						<td class="left">图片样例<span class='red'>*</span></td>
						<td class="right">
							<img src="<s:property value="travelHotelImage.image.path"/>" >
							<s:if test="travelHotelImage.imageId>0">名称:&nbsp;&nbsp; <s:property value='travelHotelImage.image.name'/></s:if>
							<s:else>未上传图片</s:else>
						</td>	
						</td>
					</tr>
					<tr>
						<td class="left">图片简介</td>
						<td class="right"><textarea  name="travelHotelImage.imageDes"  rows="5" cols="40"><s:property value='travelHotelImage.imageDes'/></textarea>
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


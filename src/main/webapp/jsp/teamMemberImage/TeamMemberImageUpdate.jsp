<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" teamMemberImage="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#teamMemberImageList').addClass("active");
	$("#form").validate({
		rules : {
			"teamMemberImage.memberName" : {
				required : true
			}
		},
		messages : {
			"teamMemberImage.memberName" : {
				required : "请输入球员名称"
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
			<h4 style="text-align:center">修改高尔夫球队球道信息</h4>
			<form action="teamMemberImageUpdateSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<tr>
						<input type="hidden" name="teamMemberImage.id" value="<s:property value="teamMemberImage.id"/>"/>
						<td class="left" width="40%">球队<span style='color: red'>*</span></td>
						<td class="right">
							<s:select name="teamMemberImage.teamId" id="teamId"
								list="teams" listKey="id" value="teamMemberImage.teamId" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">球队图片<span style='color: red'>*</span></td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							</td>	
						</td>
					</tr>
					<tr>
						<td width="15%" class="left">图片样例<span style='color: red'>*</span></td>
						<td class="right">
							<img src="<s:property value="teamMemberImage.image.path"/>" onclick="" width="200"
								height="200">
							<s:if test="teamMemberImage.imageId>0">名称:&nbsp;&nbsp; <s:property value='teamMemberImage.image.name'/></s:if>
							<s:else>未上传图片</s:else>
						</td>	
						</td>
					</tr>
					<tr>
						<td class="left">照片名称<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="40" name="teamMemberImage.memberName" value="<s:property value='teamMemberImage.memberName'/>"/></td>
					</tr>
					<tr>
						<td class="left">图片简介</td>
						<td class="right"><textarea  name="teamMemberImage.imageDes"  rows="5" cols="60"><s:property value='teamMemberImage.imageDes'/></textarea>
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


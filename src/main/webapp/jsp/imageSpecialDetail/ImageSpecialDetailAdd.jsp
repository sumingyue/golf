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
$(document).ready(function() {
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
			<form action="imageSpecialDetailAddSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan='4'>
						<h4 style="text-align:center">新增高尔夫专题图片信息</h4>
					</td></tr>
					<tr>
						<td class="left" width="40%" colspan="2">专题名称<span class='red'>*</span></td>
						<td class="right" colspan="2">
							<s:select name="imageSpecialDetail.imageSpecialId" id="imageSpecialId"
								list="imageSpecials" listKey="id" listValue="name"  theme="simple" >
							</s:select>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片01<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片02<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片03<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片04<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片05<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片06<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片07<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片08<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片09<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td class="left">上传图片10<span class='red'>*</span></td>
						<td class="right"><input type="file" name="uploads"
							id="fileUpload_upload"></td>
						<td class="left">图片简介<span class='red'>*</span></td>
						<td class="right"><textarea  name="des"  rows="2" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="text-align:center">
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


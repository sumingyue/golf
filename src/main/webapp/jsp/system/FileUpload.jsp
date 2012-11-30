<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<html>
<head>
<title>上传图片</title></head>
<STYLE type=text/css>
table {
	border: 1px solid #AEDEF2;
	text-align: left;
	width: 100%;
}
.thcenter {
	text-align: center;
	height: 20px;
	font-size: 16px;
	color: #06C;
	font-weight: bold;
	text-align: center;
	font-family: 微软雅黑,  simsun, serif, Verdana, Geneva, Arial;
}
th {	
	color: #06C;
	text-align: right;
	font-size: 15px;
	font-family: 微软雅黑, simsun, serif, Verdana, Arial;
}
input {
	color: #57ac03;
	font-family: 微软雅黑, simsun, serif, Verdana, Geneva, Arial;
}

.inputSelect {
	width: 145px;
}

.inputSubmit {
	width: 80px;
	background:#DAF0F1;
	color: #06C;
}
</STYLE>
<body>
<form id="fileUpload" name="fileUpload" action="fileUpload.do" id="form" method="post" enctype="multipart/form-data">
	<table>
		<tbody><tr>
			<th>文件文件</th>
			<td><input type="file" name="upload" id="fileUpload_upload"/>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input name="submint" type="submit" class="inputSubmit" value="提    交"/></td>
		</tr>
	</tbody></table>
</form>
</body>
</html>
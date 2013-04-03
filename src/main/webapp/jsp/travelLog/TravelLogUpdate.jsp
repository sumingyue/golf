<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	var type = <s:property value='travelLog.type'/>;
	$('#travelLog_type').attr("value",type);
	$('#travelLogList').addClass("active");
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
			<form action="travelLogUpdateSubmit.do" id="form" method="post">
				<table class="table table-striped table-bordered" width="100%">
					<input type="hidden" name="travelLog.id" value="<s:property value="travelLog.id"/>"/>
					<tr><td colspan='2'>
						<h4 style="text-align:center">修改旅游新闻信息</h4>
					</td></tr>
					<tr>
						<td class="left" width="15%">旅游<span class='red'>*</span></td>
						<td class="right">
						<s:select name="travelLog.travelId"
							list="travels" listKey="id" listValue="name" 
							value="travelLog.travelId" theme="simple" >
						</s:select>
					</tr>
					<tr>
						<td width="15%" class="left">标题<span class='red'>*</span></td>
						<td class="right"><input type="text" size="50"
							name="travelLog.title" value="<s:property value="travelLog.title"/>"/></td>
					</tr>
					<tr>
						<td width="15%" class="left">内容<span class='red'>*</span></td>
						<td class="right"><textarea id="editor1" name="travelLog.content"
								rows="10" cols="80"><s:property value="travelLog.content"/></textarea></td>
					</tr><tr><td colspan="2" style="text-align:center"><button type="submit" class="btn btn-primary  btn-large">提交</button></tr>
				</table>
			</form>
			<ckeditor:replace replace="editor1" basePath="ckeditor/" />
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

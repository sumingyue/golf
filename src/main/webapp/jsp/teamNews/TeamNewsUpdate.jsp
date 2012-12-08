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
	var type = <s:property value='teamNews.type'/>;
	$('#teamNews_type').attr("value",type);
	$('#teamNewsList').addClass("active");
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
			<h4 style="text-align:center">修改球队新闻信息</h4>
			<form action="teamNewsUpdateSubmit.do" id="form" method="post">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<input type="hidden" name="teamNews.id" value="<s:property value="teamNews.id"/>"/>
					<tr>
						<td class="left" width="15%">球队<span style='color: red'>*</span></td>
						<td class="right">
						<s:select name="teamNews.teamId"
							list="teams" listKey="id" listValue="name" 
							value="teamNews.teamId" theme="simple" >
						</s:select>
					</tr>
					<tr>
						<td class="left" width="15%">分类<span style='color: red'>*</span></td>
						<td class="right">
							<select name="teamNews.type" id="teamNews_type">
								<option value="1">球队新闻</option>
								<option value="2">活动报道</option>
								<option value="3">月历成绩</option>
								<option value="4">精彩图文</option>
								<option value="5">规章制度</option>
							</select>
						</td>
					</tr>
					<tr>
						<td width="15%" class="left">标题<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="50"
							name="teamNews.title" value="<s:property value="teamNews.title"/>"/></td>
					</tr>
					<tr>
						<td width="15%" class="left">内容<span style='color: red'>*</span></td>
						<td class="right"><textarea id="editor1" name="teamNews.content"
								rows="10" cols="80"><s:property value="teamNews.content"/></textarea></td>
					</tr><tr><td colspan="2" align="center"><button type="submit" class="btn">提交</button></tr>
				</table>
			</form>
			<ckeditor:replace replace="editor1" basePath="ckeditor/" />
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

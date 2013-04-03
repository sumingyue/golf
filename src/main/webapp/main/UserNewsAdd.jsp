<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html>
<html>
<head>
<title>苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站</title>
<meta name="Description" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<meta name="Keyword" content="苏州高尔夫网 -- 商务高球 | 名人高球 | 高球经营 | 球场设计 | 高球之源 | 高球活动 | 苏州专业高尔夫门户网站">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.override.css" rel="stylesheet">
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
var calendar = null;
  $(document).ready(function() {
	  $('#service').addClass("active");
	  var myDate = new Date()
		
	  function formateDate(newYMD){
			return newYMD.getFullYear()+"-"+(newYMD.getMonth()+1)+"-"+newYMD.getDate()+" "+
				newYMD.getHours()+":"+newYMD.getMinutes();
		}
		document.getElementById('news.validateDate').value=formateDate(myDate);
		
		 $("#form").validate({
				rules : {
					"news.title" : {
						required : true
					}
				},
				messages : {
					"news.title" : {
						required : "请输入新闻标题"
					}
				}
			});
  });
</script>
</head>
<body>
	<div class="container">
	<jsp:include page="./Head.jsp"></jsp:include>
	<div>
		<ul class="breadcrumb">
			<li>当前位置：</li>
			<li><a href="index.do">首页</a> <span class="divider">/</span></li>
			<li class="active">新闻发布</li>
		</ul>
	</div>
		<div class="row">
			<div class="span12">
				<form action="userAddNewsSub.do" id="form" method="post"
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered">
					<tr>
						<td width="15%" class="left">新闻标题<span class='red'>*</span></td>
						<td ><input type="text" size="50"
							name="news.title" /></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻图片</td>
						<td ><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea id="editor1" name="news.content"
								rows="30"></textarea></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻作者</td>
						<td ><input type="text" size="50"
							name="news.author" /></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻来源</td>
						<td ><input type="text" size="80"
							name="news.source" value="苏州高尔夫网" /><span class="red">&nbsp;新闻出处</span></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻关键字</td>
						<td ><input type="text" size="80"
							name="news.keyword" /><span class="red">&nbsp;多个关键字用 | 隔开</span></td>
					</tr>
						<tr>
							<td colspan="2" style="text-align:center">
								<button type="submit" class="btn btn-primary">提交</button>
						</tr>
					</table>
			</form>
			<ckeditor:replace replace="editor1" basePath="ckeditor/" />
			</div>
		</div>
	<jsp:include page="./Foot.jsp"></jsp:include>
    </div>
</body>
</html>




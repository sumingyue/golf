<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<html>
<head>
<title>苏州高尔夫网</title>

<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet"
	href="ckeditor/_samples/sample.css" />
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/admin.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

<script type="text/javascript">
var calendar = null;
  $(document).ready(function() {
	  $('#newsList').addClass("active");
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
					},
					"news.validateDate" :{
						required : true,
						date: true
					}
				},
				messages : {
					"news.title" : {
						required : "请输入新闻标题"
					},
					"news.validateDate" :{
						required : "请点击选择新闻发布日期",
						date : "请输入正确的日期格式"
					}
				}

			});
  });
</script>
</head>
  <body youdao="bind">
	<div class="wrap container_24">
		<jsp:include page="./Head.jsp"></jsp:include>

		<div class="grid_24">
			<h2 style="text-align:center;color:#666;font-size:16px">新增新闻</h2>
			<form action="unas.do" id="form" method="post"
				enctype="multipart/form-data">
				<table align="center" cellpadding="2" cellspacing="1" width="100%">
					<%-- <tr>
						<td width="15%" class="left">一级分类<span style='color: red'>*</span></td>
						<td class="right"><s:select name="news.categoryId"
								onchange="categoryChanged()"
								list="categoryList" listKey="id" listValue="name"
								value="categoryId" theme="simple" cssClass="select">
							</s:select></td>
					</tr>
					<tr>
						<td width="15%" class="left">二级分类<span style='color: red'>*</span></td>
						<td class="right"><select id="news_smallCategoryId"
							name="news.smallCategoryId" class="select">
								<option value="0">_ALL</option>
						</select></td>
					</tr> --%>
					<tr>
						<td width="15%" class="left">新闻标题<span style='color: red'>*</span></td>
						<td class="right"><input type="text" size="50"
							name="news.title" /></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻图片</td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea id="editor1" name="news.content"
								rows="30"></textarea></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻作者</td>
						<td class="right"><input type="text" size="50"
							name="news.author" /></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻来源</td>
						<td class="right"><input type="text" size="80"
							name="news.source" value="苏州高尔夫网" /><span class="red">&nbsp;新闻出处</span></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻关键字</td>
						<td class="right"><input type="text" size="80"
							name="news.keyword" /><span class="red">&nbsp;多个关键字用 | 隔开</span></td>
					</tr>
						<tr>
							<td class="left">发表时间</td>
							<td class="right"><%-- <input type="radio" name="news.status"
								value="1" checked="">已审 <input type="radio"
								name="news.status" value="0">未审 &nbsp;&nbsp;<font
								color="#006600">|</font>&nbsp;&nbsp; <input type="radio"
								name="news.recommend" value="1">已首页推荐 <input
								type="radio" name="news.recommend" value="0" checked="">未首页推荐
								&nbsp;&nbsp;<font color="#006600"> <font color="#006600">|</font>&nbsp;&nbsp;
									优先级： <select name="news.priority" id="new_priority">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
								</select> | --%>
							</font><input type="text" size="14"
								name="news.validateDate" id="news.validateDate" /> <img
								src="img/calendar.gif"
								onclick="showCalendar('news.validateDate');"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="submit" class="btn">提交</button>
						</tr>
					</table>
			</form>
			<ckeditor:replace replace="editor1" basePath="ckeditor/" />
      </div>
		<jsp:include page="./Foot.jsp"></jsp:include>
		</div>
</body>
</html>


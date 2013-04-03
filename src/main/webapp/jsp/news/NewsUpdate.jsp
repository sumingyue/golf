<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html>
<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<link rel='stylesheet' type='text/css' href='css/calendar.css' />
<script src="js/calendar.js" type="text/javascript"></script>
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/admin.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
  var calendar = null;
  $(document).ready(function() {
		var status = <s:property value='news.status'/>;
		var recommend = <s:property value='news.recommend'/>;
		var priority = <s:property value='news.priority'/>;
		
		setCheckedValue('news.status',status);
		setCheckedValue('news.recommend',recommend);
		$('#new_priority').attr("value",priority);
		$('#newsList').addClass("active");
		
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
<body>
  <%@include file="./../Head.jsp"%>
  </br>
  </br>
  <div class="container-fluid">
    <div class="row-fluid">
      <%@include file="./../Menu.jsp"%>
      <div class="span10">
			<form action="newsUpdateSubmit.do" id="form" method="post"
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<tr><td colspan="2"><h4 style="text-align:center">编辑新闻</h4></td></tr>
					<input type="hidden" name="news.id" value="<s:property value="news.id"/>"/>
					<tr>
						<td width="15%" class="left">一级分类<span class='red'>*</span></td>
						<td class="right"><s:select name="news.categoryId"
								onchange="categoryChanged()" 
								list="categoryList" listKey="id" listValue="name"
								value="news.categoryId" theme="simple" cssClass="select">
							</s:select></td>
					</tr>
					<tr>
						<td width="15%" class="left">二级分类<span class='red'>*</span></td>
						<td class="right"><s:select name="news.smallCategoryId" 
								list="smallCategoryList" listKey="id" listValue="name"
								value="news.smallCategoryId" theme="simple" cssClass="select">
							</s:select>
						</td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻标题<span class='red'>*</span></td>
						<td class="right"><input type="text" size="50"
							name="news.title"  value="<s:property value='news.title'/>"></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻图片</td>
						<td class="right"><input type="file" name="upload"
							id="fileUpload_upload">
							<s:if test="news.imageId>0">图片名称<s:property value='news.image.name'/></s:if>
							<s:else>未上传图片</s:else>
						</td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻内容<span class='red'>*</span></td>
						<td class="right"><textarea id="editor1" name="news.content" rows="30"><s:property value="news.content"/></textarea></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻作者</td>
						<td class="right"><input type="text" size="50"
							name="news.author"  value="<s:property value='news.author'/>"/></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻来源</td>
						<td class="right"><input type="text" size="80"
							name="news.source"  value="<s:property value='news.source'/>"/><span class="red">&nbsp;新闻出处</span></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻关键字</td>
						<td class="right"><input type="text" size="80"
							name="news.keyword" value="<s:property value='news.keyword'/>" /><span class="red">&nbsp;多个关键字用 | 隔开</span></td>
					</tr>
					<tr>
						<td class="left">系统设置</td>
						<td class="right"><input type="radio" name="news.status"
							value="2" checked="">已审 <input type="radio"
							name="news.status" value="1">未审 &nbsp;&nbsp;<font
							color="#006600">|</font>&nbsp;&nbsp; <input type="radio"
							name="news.recommend" value="2">已首页推荐 <input type="radio"
							name="news.recommend" value="1" checked="">未首页推荐
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
							</select> |
						</font>&nbsp;&nbsp; 发表时间：<input type="text" size="14"
							name="news.validateDate" id="news.validateDate" value="<s:property value='news.validateDateStr'/>"/> <img
							src="img/calendar.gif"
							onclick="showCalendar('news.validateDate');"></td>
					</tr>
					<tr>
						<td class="left">用户浏览</td>
						<td > &nbsp;&nbsp;&nbsp;浏览量 ${news.viewNumber} &nbsp;&nbsp;&nbsp;
						顶 ${news.good} &nbsp;&nbsp;&nbsp;
						踩 ${news.bad} &nbsp;&nbsp;&nbsp;</td>
					</tr>
						<tr>
							<td colspan="2" style="text-align:center">
								<button type="submit" class="btn btn-primary  btn-large">提交</button>
						</tr>
				</table>
			</form><ckeditor:replace replace="editor1" basePath="ckeditor/" />
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>

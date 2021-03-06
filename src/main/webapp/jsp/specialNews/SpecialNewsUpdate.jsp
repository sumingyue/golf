<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/admin.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
  var calendar = null;
  $(document).ready(function() {
		var priority = <s:property value='specialNews.priority'/>;
		
		$('#new_priority').attr("value",priority);
		$('#specialNewsList').addClass("active");
		
		 $("#form").validate({
				rules : {
					"specialNews.title" : {
						required : true
					}
				},
				messages : {
					"specialNews.title" : {
						required : "请输入专题新闻标题"
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
			<form action="specialNewsUpdateSubmit.do" id="form" method="post"
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered"
				 width="100%">
					<tr><td colspan='2'>
						<h4 style="text-align:center">编辑专题新闻</h4>
					</td></tr>
					<input type="hidden" name="specialNews.id" value="<s:property value="specialNews.id"/>"/>
					<tr>
						<td width="15%" class="left">新闻标题<span class='red'>*</span></td>
						<td class="right"><input type="text" size="50"
							name="specialNews.title"  value="<s:property value='specialNews.title'/>"></td>
					</tr>
					<tr>
						<td width="15%" class="left">新闻内容<span class='red'>*</span></td>
						<td class="right"><textarea id="editor1" name="specialNews.content" rows="30"><s:property value="specialNews.content"/></textarea></td>
					</tr>
					<tr>
						<td class="left">系统设置</td>
						<td class="right"></font>&nbsp;&nbsp;
								优先级： <select name="specialNews.priority" id="new_priority">
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
						</font</td>
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

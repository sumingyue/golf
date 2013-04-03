<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<!DOCTYPE html><html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" newsComments="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var type = "<s:property value='newsComments.type'/>";
	$('#newsComments_type').attr("value",type);
	$('#newsCommentsList').addClass("active");
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
			<h4 style="text-align:center">修改新闻评论信息</h4>
			<form action="newsCommentsUpdateSubmit.do" id="form" method="post"  
				enctype="multipart/form-data">
				<table class="table table-striped table-bordered" width="100%">
					<input type="hidden" name="newsComments.id" value="<s:property value="newsComments.id"/>"/>
					<tr>
						<td class="left" width="30%">新闻标题<span class='red'>*</span></td>
						<td class="right">
							<input type="text" size="30" name="newsComments.newsId" value="<s:property value="newsComments.newsId"/>"/>
						</td>
					</tr>
					<tr>
						<td class="left">用户昵称<span class='red'>*</span></td>
						<td class="right"><input type="text" size="30" name="newsComments.userName" value="<s:property value="newsComments.userName"/>"/></td>
					</tr>
					<tr>
						<td class="left">用户评论<span class='red'>*</span></td>
						<td class="right"><textarea  name="newsComments.content"  rows="5" cols="60"><s:property value="newsComments.content"/></textarea>
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


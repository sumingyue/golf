<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/tld/struts-tags.tld"%>

<html>
<head>
<title>苏州高尔夫后台管理系统</title>

<link href="css/bootstrap.min.css" rel="stylesheet" courtComments="screen">
<link rel='stylesheet' type='text/css' href='css/admin.css' />
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("tr:even").addClass("even");
	$("tr:odd").addClass("odd");
	$("tr").bind("mouseout",function(){
		this.style.backgroundColor='';
	});
	$("tr").bind("mouseover",function(){
		this.style.backgroundColor='#BFDFFF'
	});
	$(".delete").bind("click",function(){
		return confirm("确定要删除此分类吗(不可恢复)？");
	});
	$('#courtCommentsList').addClass("active");
});

function courtChanged(){
	var courtId = $('#courtId').val();
	window.location="?courtId="+courtId;
}
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
<!--         	<h4 style="text-align:center">
 		俱乐部评论信息管理</h4>-->	
			<div width="100%" style="text-align:center"><s:select name="courtId" id="courtId"
					onchange="courtChanged()"
					list="courts" listKey="id" listValue="name" 
					headerKey="0" headerValue="ALL"
					value="courtId" theme="simple" >
			</s:select>
			</div>
			<table  align="center" cellpadding="2" cellspacing="1"  class="table" id="courtCommentsList">
				<tr class="title">
					<th width="5%">序号</th>
					<th width="15%">用户名</th>
					<th width="70%">评论内容</th>
					<th width="10%">操作&nbsp;&nbsp;&nbsp;&nbsp;<a href="courtCommentsAdd.do" >新增</a></th>
				</tr>
				<s:iterator value="courtCommentss" status="vs">
					<tr>
					<td><s:property value='#vs.index+1'/></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="content" /></td>
					<td><a href="courtCommentsUpdate.do?courtCommentsId=<s:property value="id"/>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
					<a class="delete" href="courtCommentsDelete.do?courtCommentsId=<s:property value="id"/>">删除</a></td>
					</tr>
				</s:iterator>
			</table>
				</br>
				<table  align="center">
					<tr >
						<td>
							共&nbsp;<s:property value="pagedTool.totalNumber"/>&nbsp;条记录
							<a href="?index=0&courtId=<s:property value="courtId"/>">首页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex-1"/>&courtId=<s:property value="courtId"/>">上一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.pageIndex+1"/>&courtId=<s:property value="courtId"/>">下一页</a>&nbsp;&nbsp;
							<a href="?index=<s:property value="pagedTool.totalPage"/>&courtId=<s:property value="courtId"/>">末页</a>&nbsp;&nbsp;
							共&nbsp;<s:property value="pagedTool.totalPage"/>&nbsp;页,当前第&nbsp;<s:property value="pagedTool.pageIndex"/>页&nbsp;
							<s:property value="pagedTool.pageSize"/>条记录/页&nbsp;
						</td>
					</tr>
				</table>
      </div>
    </div>
    <%@include file="./../Foot.jsp"%>
  </div>
</body>
</html>
